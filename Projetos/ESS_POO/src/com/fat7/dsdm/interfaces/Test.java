package com.fat7.dsdm.interfaces;


public class Test {

	public static void main(String[] args){
		doOperations(new Auto());
		doOperations(new TV());
		doOperations(new Microware());
	}

	private static void doOperations(Operations ops) {
		ops.turnOn();
		ops.turnOff();
	}
	
}
