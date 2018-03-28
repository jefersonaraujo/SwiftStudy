package br.edu.fa7.engenharia;

public class Tadutor {


	public double fahrToCelsius(double fahr){
		
		double resultado = (fahr - 32) * 5 / 9;
		
		return resultado;
	}
	
	public double celsiusToFahr(double celsius){
		
		double resultado = (celsius * 9.0 / 5.0) + 32;
		
		return resultado;
	}
	

}
