package com.fat7.dsdm.agregation;

public class Test {

	public static void main(String arg[]){
		Student s = new Student(1,"Eu");
		Monitor m = new Monitor(2, "Tu");
		Trainee t = new Trainee(3, "Ele");
//		Team team = new Team();
		TeamArrayList team = new TeamArrayList();
		team.registry(s);
		team.registry(m);
		team.registry(t);
		System.out.println(team.size());
		System.out.println(team.search(m.getRegistration()));
		team.unregistry(m);
		team.unregistry(s.getRegistration());
		System.out.println(team.size());
	}
	
}
