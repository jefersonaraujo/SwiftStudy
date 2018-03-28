package com.fat7.dsdm.threads;

public class Test {

	public static void main(String[] args) {
		HelloWorldThread helloWorldThread = new HelloWorldThread();
		exec(helloWorldThread);
	}

	private static void exec(HelloWorldThread helloWorldThread) {
		helloWorldThread.start();
		while (true) {
			System.out.println("Executando...");
		}
	}

}
