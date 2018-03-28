package br.edu.fa7.engenharia;

import static org.junit.Assert.*;

import org.junit.Test;

public class TadutorTest {

	@Test
	public void testFahrToCelsius() {
		
		Tadutor tradutor = new Tadutor();
		double result = tradutor.fahrToCelsius(59.0);
		
		assertEquals(15.0, result, 0.1);
			
	}
	

	@Test
	public void testValorNegativoFahrToCelsius() {
		
		Tadutor tradutor = new Tadutor();
		double result = tradutor.fahrToCelsius(-32);
		
		assertEquals(-35.55, result, 0.1);
			
	}
	
	@Test
	public void testCelsiusToFahr() {
		
		Tadutor tradutor = new Tadutor();
		double result = tradutor.celsiusToFahr(15);
		
		assertEquals(59.0, result, 0.1);
			
	}
	
	@Test
	public void testValorNegativoCelsiusToFahr() {
		
		Tadutor tradutor = new Tadutor();
		double result = tradutor.celsiusToFahr(-35.55);
		
		assertEquals(-32.0, result, 0.1);
			
	}
	
}
