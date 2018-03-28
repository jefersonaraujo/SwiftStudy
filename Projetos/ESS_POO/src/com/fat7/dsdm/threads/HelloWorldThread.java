package com.fat7.dsdm.threads;

public class HelloWorldThread extends Thread {
	
	@Override
	public void run() {
		while (true)
			System.out.println("Thread: " + getId());
	}
	
}
