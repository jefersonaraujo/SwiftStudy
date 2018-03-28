package com.fat7.poo.ess.q2;

public class TraineeAdapter implements IEmployee{

	private ITrainee trainee;
	private boolean registredEntry;
	
	public TraineeAdapter(ITrainee trainee) {
		this.trainee = trainee;
	}

	@Override
	public void receiveSalary() {
		trainee.receiveMoney();
	}

	@Override
	public void hitPoint() {
		if(registredEntry)
			trainee.regEntry();
		else
			trainee.regExit();
		registredEntry = !registredEntry;
	}

	@Override
	public void work() {
		trainee.traineer();
	}

}
