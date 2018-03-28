package com.fat7.dsdm.inheritance;

import java.util.Date;

public class Functionary {
	
	private String name;
	private String registration;
	private Sex sex;
	private Date birthDate;
	private float salario;
	
	public static enum Sex {MALE, FEMALY}
	
	public Functionary(String name, Sex sex, Date birthDate) {
		this.name = name;
		this.sex = sex;
		this.birthDate = birthDate;
	}
	
	public void hire(String registration, float salario) {
		this.registration = registration;
		this.salario = salario;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
}
