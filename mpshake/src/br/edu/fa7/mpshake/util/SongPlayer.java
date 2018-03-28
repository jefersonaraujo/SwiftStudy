package br.edu.fa7.mpshake.util;

import java.io.IOException;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import br.edu.fa7.mpshake.interfaces.IPlayer;
import br.edu.fa7.mpshake.interfaces.OnMusicFinishListener;

public class SongPlayer implements IPlayer, OnCompletionListener {

	private MediaPlayer mediaPlayer;
	private OnMusicFinishListener listener;

	public SongPlayer(OnMusicFinishListener listener) {

		mediaPlayer = new MediaPlayer();
		mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mediaPlayer.setOnCompletionListener(this);

		this.listener = listener;

	}

	@Override
	public void start() {
		if (!mediaPlayer.isPlaying()) {
			mediaPlayer.start();
		}
	}

	@Override
	public void stop() {
		if (mediaPlayer.isPlaying()) {
			mediaPlayer.stop();
			mediaPlayer.reset();
		}
	}

	@Override
	public void pause() {
		if (mediaPlayer.isPlaying()) {
			mediaPlayer.pause();
		}
	}

	@Override
	public void prepare(String songPath) throws IllegalStateException,
			IOException {
		mediaPlayer.setDataSource(songPath);
		mediaPlayer.prepare();
	}

	@Override
	public boolean isPlaying() {
		return mediaPlayer.isPlaying();
	}

	@Override
	public int getDuration() {
		return mediaPlayer.getDuration();
	}

	@Override
	public int getCurrentPosition() {
		return mediaPlayer.getCurrentPosition();
	}
	
	@Override
	public void reset() {
		mediaPlayer.reset();
	}

	@Override
	public void seekTo(int value) {
		mediaPlayer.seekTo(value);
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		listener.onMusicFinish();
	}

}
