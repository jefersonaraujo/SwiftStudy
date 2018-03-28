package br.edu.fa7.mpshake.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import android.os.Environment;
import br.edu.fa7.mpshake.model.Song;

public class SongUtil {

	/**
	 * Get all music files on the device
	 * @return The music list
	 */
	public List<Song> getAllMusics() {

		// Create the music list
		List<Song> musics = null;
		
		// Get the local music directory
		File localMusicDirectory = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
		
		// Get all music files
		File[] musicFiles = localMusicDirectory.listFiles(new FileExtensionFilter());
		
		// Iterate over music files and create the music list
		if(musicFiles.length > 0){
			
			musics = new ArrayList<Song>();
			for (File music : musicFiles) {
				Song m = new Song(music.getName(), music.getPath());
				musics.add(m);
			}
		}

		// Retun the music list
		return musics;
	}

	private class FileExtensionFilter implements FilenameFilter {
		@Override
		public boolean accept(File dir, String filename) {
			return (filename.endsWith(".mp3") || filename.endsWith(".MP3"));
		}
	}

}
