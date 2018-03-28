package com.fat7.dsdm.exception;

public class Student {

	private long registration;
	private String name;
	private double scores[];
	
	public Student(long registration, String name) {
		this.registration = registration;
		this.name = name;
		scores = new double[4];
	}

	public long getRegistration() {
		return registration;
	}

	public String getName() {
		return name;
	}

	public double getScore(int test){
		return scores[test-1];
	}
	
	@Override
	public String toString() {
		return "Student [registration=" + registration + ", name=" + name + "]";
	}
	
	public void setScore(int test, double score) throws InvalidScoreException, InvalidTestException{
		if(test <= 0 || test > 4)
			throw new InvalidTestException(test);
		if(score <= 0 || score > 10)
			throw new InvalidScoreException(test, score);
		scores[test-1] = score;
	}
	
}
