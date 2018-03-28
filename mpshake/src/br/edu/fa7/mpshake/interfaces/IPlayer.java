package br.edu.fa7.mpshake.interfaces;

import java.io.IOException;

public interface IPlayer {

	public void start();

	public void stop();

	public void pause();
	
	public boolean isPlaying();
	
	public int getDuration();
	
	public int getCurrentPosition();
	
	public void seekTo(int value);
	
	public void reset();

	public void prepare(String songPath) throws IllegalStateException,
			IOException;

}
