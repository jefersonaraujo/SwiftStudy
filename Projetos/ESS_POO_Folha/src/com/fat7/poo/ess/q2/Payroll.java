package com.fat7.poo.ess.q2;
import java.util.Date;


public class Payroll {

	public static void main(String[] args) {
		Payroll payroll = new Payroll();
		IEmployee employee = new Employee(0, "Chico", 'M', new Date(), "Gerente", "Num sei");
		payroll.pay(employee);
		ITrainee trainee = new Trainee(0, "Ele", 'M', new Date());
		TraineeAdapter traineeAdapter = new TraineeAdapter(trainee);
		payroll.pay(traineeAdapter);
	}

	public void pay(IEmployee employee){
		employee.receiveSalary();
	}
	
}
