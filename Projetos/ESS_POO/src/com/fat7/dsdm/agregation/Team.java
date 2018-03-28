package com.fat7.dsdm.agregation;

import java.util.ArrayList;

public class Team {

	private ArrayList<Student> students = new ArrayList<>();
	
	public void registry(Student s){
		students.add(s);
	}
	
	public void unregistry(long registration){
		for (Student s : students)
			if(s.getRegistration() == registration){
				students.remove(s);
				break;
			}
	}

	public void unregistry(Student s){
		students.remove(s);
	}
	
	public void listTeam(){
		System.out.println("Estudantes na turma: \n");
		for (Student s : students)
			System.out.println(s.toString() + "/n");
	}
	
	public Student search(long registration){
		for (Student s : students)
			if(s.getRegistration() == registration)
				return s;
		return new Student(0, "Student not found.");
	}

	public int size() {
		return students.size();
	}
	
}
