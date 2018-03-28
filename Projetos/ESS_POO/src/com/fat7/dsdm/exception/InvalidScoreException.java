package com.fat7.dsdm.exception;

public class InvalidScoreException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int test;
	private double score;

	public InvalidScoreException(int test, double score) {
		super("Invalid Score");
		this.test = test;
		this.score = score;
	}

	public int getTest() {
		return test;
	}

	public double getScore() {
		return score;
	}

}
