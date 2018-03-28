package br.edu.exercicios1;

public class Fatorial {	
	
   public static long fatorial(long n){
	   if(n < 0){
		    throw new IllegalArgumentException();
	   }
	   
	   if(n==0) return 1;
	   else return n * fatorial(n - 1);
   }
   
   public static double fahrToCelsius(double fahrenheit){
	   double celsius = (5.0/9.0) * (fahrenheit - 32);
	   return celsius;
   }
   
	
}
