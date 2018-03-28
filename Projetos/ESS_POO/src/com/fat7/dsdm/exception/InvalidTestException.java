package com.fat7.dsdm.exception;

public class InvalidTestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int test;

	public InvalidTestException(int test) {
		super("Invalid Test");
		this.test = test;
	}

	public int getTest() {
		return test;
	}

}
