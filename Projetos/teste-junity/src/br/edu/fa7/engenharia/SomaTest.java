package br.edu.fa7.engenharia;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomaTest {

	@Test
	public void test() {
		Soma soma = new Soma();
		int result = soma.calculaSoma(10, 35);
		assertEquals(45, result);
		
	}
	
	@Test
	public void testSomaNegativo() {
		Soma soma = new Soma();
		int result = soma.calculaSoma(-10, 35);
		assertEquals(25, result);
		
	}
	
	@Test
	public void testSomaNegativos() {
		Soma soma = new Soma();
		int result = soma.calculaSoma(-10, -35);
		assertEquals(-45, result);
		
	}
	
	@Test
	public void testSomaZero() {
		Soma soma = new Soma();
		int result = soma.calculaSoma(0, 35);
		assertEquals(35, result);
		
	}


}
