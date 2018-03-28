package com.fat7.poo.ess.q2;
import java.util.Date;


public class Employee implements IEmployee{

	private long reg;
	private String name;
	private char sex;
	private Date birthDate;
	private String role;
	private String function;
	
	public Employee(long reg, String name, char sex, Date birthDate,
			String role, String function) {
		this.reg = reg;
		this.name = name;
		this.sex = sex;
		this.birthDate = birthDate;
		this.role = role;
		this.function = function;
	}
		
	public long getReg() {
		return reg;
	}

	public String getName() {
		return name;
	}

	public char getSex() {
		return sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getRole() {
		return role;
	}

	public String getFunction() {
		return function;
	}

	@Override
	public void receiveSalary() {
		System.out.println("Empregado recebeu.");
	}
	
	@Override
	public void hitPoint() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void work() {
		// TODO Auto-generated method stub
		
	}
	
}
