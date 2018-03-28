package com.fat7.dsdm.agregation;

import java.util.ArrayList;
import java.util.Iterator;

public class TeamArrayList {

	private ArrayList<Student> students = new ArrayList<>();
	
	public void registry(Student s){
		students.add(s);
	}
	
	public void unregistry(long registration){
		for (int i=0; i<students.size(); i++)
			if(students.get(i).getRegistration() == registration){
				students.remove(i);
				break;
			}
	}

	public void unregistry(Student s){
		students.remove(s);
	}
	
	public void listTeam(){
		System.out.println("Estudantes na turma: \n");
		Iterator<Student> it = students.iterator();
		while(it.hasNext())
			System.out.println(it.next().toString() + "/n");
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
