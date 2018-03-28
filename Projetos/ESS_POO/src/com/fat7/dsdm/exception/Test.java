package com.fat7.dsdm.exception;

public class Test {

	public static void main(String[] args) {
		Student s = new Student(1, "Eu");
		try {
			s.setScore(1, 2);
			s.setScore(1, 12);
			s.setScore(6, 2);
		} catch (InvalidScoreException e) {
			System.out.println(e.getMessage() + " " + e.getTest() + " " + e.getScore());
		} catch (InvalidTestException e) {
			System.out.println(e.getMessage() + " " + e.getTest());
		}
		finally {
			System.out.println("Fim");
		}
	}

}
