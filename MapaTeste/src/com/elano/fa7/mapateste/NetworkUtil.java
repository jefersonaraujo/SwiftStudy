package com.elano.fa7.mapateste;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import android.os.Build;
import android.os.Handler;
import android.util.Log;

public class NetworkUtil {
	
	private Handler handler;
	private static NetworkUtil instance;
	
	private NetworkUtil(){
		handler = new Handler();
	}
	
	public static NetworkUtil getInstance(){
		if(instance == null)
			instance = new NetworkUtil();
		
		return instance;
	}

	public void ping(String url) {
		
		Log.i("Ping", "Iniciando processo");
		
		handler.post(new PingProcess(url));
	}
	
	private class PingProcess implements Runnable{
		
		private String url;
		
		public PingProcess(String url){
			this.url = url;
		}

		@Override
		public void run() {
			try {
				Process process = null;

				if (Build.VERSION.SDK_INT <= 16) {
					// shiny APIS
					process = Runtime.getRuntime().exec(
							"/system/bin/ping -w 1 -c 1 " + url);

				} else {

					process = new ProcessBuilder().command("/system/bin/ping -c", url)
							.redirectErrorStream(true).start();
				}
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(
		                process.getInputStream()));
				String line=null;

			        while ( (line = reader.readLine()) != null)   
			        {
			           Log.i("Ping",line);
			        }

			        reader.close();

			        process.destroy();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
