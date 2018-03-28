package com.fat7.dsdm.agregation;

public class Student {

	private long registration;
	private String name;
	
	public Student(long registration, String name) {
		this.registration = registration;
		this.name = name;
	}

	public long getRegistration() {
		return registration;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student [registration=" + registration + ", name=" + name + "]";
	}
	
}
