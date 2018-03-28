package com.fat7.dsdm.threads;

public class EvenOdd implements Runnable{

	private boolean par;

	public EvenOdd(boolean par) {
		this.par = par;
	}

	@Override
	public void run() {
		int init = (par) ? 0 : 1;
		while(init < 1000)
			System.out.println((par) ? "Even: " : "Odd: " + init++);
	}
	
}
