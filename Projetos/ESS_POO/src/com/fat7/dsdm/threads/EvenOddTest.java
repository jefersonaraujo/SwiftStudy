package com.fat7.dsdm.threads;

public class EvenOddTest {

	public static void main(String[] args) {
		Runnable par = new EvenOdd(true);
		Runnable impar = new EvenOdd(false);
		new Thread(par).start();
		new Thread(impar).start();
	}

}
