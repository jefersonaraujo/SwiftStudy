package br.edu.fa7.mpshake.adapter;

import java.util.List;

import br.edu.fa7.mpshake.R;
import br.edu.fa7.mpshake.model.Song;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SongAdapter extends BaseAdapter {

	private Context context;
	private List<Song> songs;

	public SongAdapter(Context context, List<Song> songs) {
		this.context = context;
		this.songs = songs;
	}

	@Override
	public int getCount() {
		return songs.size();
	}

	@Override
	public Object getItem(int position) {
		return songs.get(position);
	}

	@Override
	public long getItemId(int position) {
		return songs.indexOf(songs.get(position));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Song song = songs.get(position);
		HolderView holder = null;
		
		if(convertView == null){
		
			LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = layoutInflater.inflate(R.layout.list_music_entry, null);
			
			holder = new HolderView();
			holder.songName = (TextView) convertView.findViewById(R.id.list_music_name);
			
			convertView.setTag(holder);
			
		} else{
			
			holder = (HolderView) convertView.getTag();
			
		}
		
		holder.songName.setText(song.getName());
		
		return convertView;
	}
	
	private static class HolderView{
		public TextView songName;
	}

}
