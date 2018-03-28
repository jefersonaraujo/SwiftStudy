package br.edu.fa7.mpshake.activity;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import br.edu.fa7.mpshake.R;
import br.edu.fa7.mpshake.adapter.SongAdapter;
import br.edu.fa7.mpshake.interfaces.OnMusicFinishListener;
import br.edu.fa7.mpshake.model.Song;
import br.edu.fa7.mpshake.util.SongPlayer;
import br.edu.fa7.mpshake.util.SongUtil;

public class MainActivity extends Activity implements OnClickListener,
		OnItemClickListener, OnMusicFinishListener, OnSeekBarChangeListener {

	private boolean prepared;
	private ListView playlist;
	private ImageButton play;
	private ImageButton stop;
	private ImageButton next;
	private ImageButton previous;
	private SeekBar songPosition;
	private TextView songInfo;
	private Handler updateWidgets;
	private SongUtil songUtil;
	private SongAdapter adapter;
	private SongPlayer player;
	private List<Song> songs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Call the super onCreate method and set the layout
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Get all widgets references
		playlist = (ListView) findViewById(R.id.main_list_playlist);
		play = (ImageButton) findViewById(R.id.main_button_play);
		stop = (ImageButton) findViewById(R.id.main_button_stop);
		next = (ImageButton) findViewById(R.id.main_button_next);
		previous = (ImageButton) findViewById(R.id.main_button_previous);
		songPosition = (SeekBar) findViewById(R.id.main_seek_song_position);
		songInfo = (TextView) findViewById(R.id.main_text_song_info);

		// Set the buttons listener
		play.setOnClickListener(this);
		stop.setOnClickListener(this);
		next.setOnClickListener(this);
		previous.setOnClickListener(this);

		// Set the listview listener
		playlist.setOnItemClickListener(this);

		// Set the seekbar listener
		songPosition.setOnSeekBarChangeListener(this);

		// Initiate the handler
		updateWidgets = new Handler();

		// Create the song util object
		songUtil = new SongUtil();

		// Creathe the song player object
		player = new SongPlayer(this);

		// Set the prepare sentinel variable to false
		prepared = false;

	}

	@Override
	protected void onResume() {

		super.onResume();

		// Get the song list
		songs = songUtil.getAllMusics();

		// Create the adapter
		adapter = new SongAdapter(this, songs);

		// Set the adapter on list view and select the first line
		playlist.setAdapter(adapter);
		playlist.setItemChecked(0, true);

	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	protected void onDestroy() {

		super.onDestroy();

		if (player.isPlaying()) {
			player.stop();
		}

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.main_button_play:
			play();
			break;
		case R.id.main_button_stop:
			stop();
			break;
		case R.id.main_button_next:
			next();
			break;
		case R.id.main_button_previous:
			previous();
			break;

		}

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		try {
			Song song = songs.get(position);

			if (player.isPlaying()) {
				player.stop();
			}

			player.prepare(song.getPath());
			player.start();

			play.setImageDrawable(getResources().getDrawable(R.drawable.pause));

			songPosition.setMax(player.getDuration());

			prepared = true;

			updateWidgets.post(new UpdateWidgetsRunnable());

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		player.seekTo(seekBar.getProgress());
	}

	@Override
	public void onMusicFinish() {

		int songId = playlist.getCheckedItemPosition() + 1;
		if (songId > -1 && songId < songs.size()) {

			try {

				player.reset();

				Song song = songs.get(songId);
				player.prepare(song.getPath());
				player.start();

				playlist.setItemChecked(songId, true);

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void play() {

		if (!player.isPlaying()) {

			try {

				Song song = songs.get(playlist.getCheckedItemPosition());

				if (!prepared) {
					player.prepare(song.getPath());
					prepared = true;
				}

				player.start();

				play.setImageDrawable(getResources().getDrawable(
						R.drawable.pause));

				songPosition.setMax(player.getDuration());

				updateWidgets.post(new UpdateWidgetsRunnable());

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			player.pause();
			play.setImageDrawable(getResources().getDrawable(R.drawable.play));

		}

	}

	private void stop() {
		if (player.isPlaying()) {
			player.stop();
			prepared = false;
			play.setImageDrawable(getResources().getDrawable(R.drawable.play));
			songPosition.setMax(0);
		}
	}

	private void next() {

		int songId = playlist.getCheckedItemPosition() + 1;
		if (songId > -1 && songId < songs.size()) {

			try {

				if (player.isPlaying()) {
					player.stop();
				}

				Song song = songs.get(songId);
				player.prepare(song.getPath());
				player.start();

				playlist.setItemChecked(songId, true);

				updateWidgets.post(new UpdateWidgetsRunnable());

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			try {

				if (player.isPlaying()) {
					player.stop();
				}

				Song song = songs.get(0);
				player.prepare(song.getPath());
				player.start();

				playlist.setItemChecked(0, true);

				updateWidgets.post(new UpdateWidgetsRunnable());

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void previous() {

		int songId = playlist.getCheckedItemPosition() - 1;
		if (songId > -1 && songId < songs.size()) {

			try {

				if (player.isPlaying()) {
					player.stop();
				}

				Song song = songs.get(songId);
				player.prepare(song.getPath());
				player.start();

				playlist.setItemChecked(songId, true);

				updateWidgets.post(new UpdateWidgetsRunnable());

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private class UpdateWidgetsRunnable implements Runnable {

		@Override
		public void run() {

			if (player.isPlaying()) {

				// Update the seek bar
				songPosition.setMax(player.getDuration());
				songPosition.setProgress(player.getCurrentPosition());

				// Format the current position info
				int secondsCurrent = player.getCurrentPosition() / 1000;
				int minutesCurrent = 0;

				while (secondsCurrent > 59) {
					secondsCurrent -= 60;
					minutesCurrent++;
				}

				String minCurrent = String.valueOf(minutesCurrent);
				String secCurrent = String.valueOf(secondsCurrent);

				if (minCurrent.length() == 1) {
					minCurrent = "0" + minCurrent;
				}

				if (secCurrent.length() == 1) {
					secCurrent = "0" + secCurrent;
				}

				// Format the duration info
				int secondsDuration = player.getDuration() / 1000;
				int minutesDuration = 0;

				while (secondsDuration > 59) {
					secondsDuration -= 60;
					minutesDuration++;
				}

				String minDuration = String.valueOf(minutesDuration);
				String secDuration = String.valueOf(secondsDuration);

				if (minDuration.length() == 1) {
					minDuration = "0" + minDuration;
				}

				if (secDuration.length() == 1) {
					secDuration = "0" + secDuration;
				}

				// Update the textview
				songInfo.setText(minCurrent + ":" + secCurrent + " of "
						+ minDuration + ":" + secDuration);

				// Send a new update
				if (player.isPlaying()) {
					updateWidgets
							.postDelayed(new UpdateWidgetsRunnable(), 1000);
				}

			} else {				
				songPosition.setProgress(0);
				songInfo.setText("");
			}

		}

	}

}
