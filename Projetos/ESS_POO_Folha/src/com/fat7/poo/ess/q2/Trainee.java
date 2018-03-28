package com.fat7.poo.ess.q2;
import java.util.Date;


public class Trainee implements ITrainee{

	private long reg;
	private String name;
	private char sex;
	private Date birthDate;
	
	public Trainee(long reg, String name, char sex, Date birthDate) {
		this.reg = reg;
		this.name = name;
		this.sex = sex;
		this.birthDate = birthDate;
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

	@Override
	public void receiveMoney() {
		System.out.println("Estagiario recebeu.");
	}

	@Override
	public void regEntry() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void regExit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traineer() {
		// TODO Auto-generated method stub
		
	}

	
}
