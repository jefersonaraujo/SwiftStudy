package br.edu.exercicios1;
import static org.junit.Assert.*;

import org.junit.Test;

public class FatorialTest {
	
	@Test
	public void testValorRetorno() {
		assertEquals(120,Fatorial.fatorial(5));
	}
	
	@Test
	public void testFatorialNegative(){
		try{
			Fatorial.fatorial(-5);
			fail("Nao existe fatorial negativo");
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testFatorialbyZero(){
		assertEquals(1,Fatorial.fatorial(0));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testRetornoCelsius() {
		assertEquals(0,Fatorial.fahrToCelsius(32), 0.2);
	}
	
	@Test
	public void testRetornoCelsiusNegative() {
		assertEquals(-18.22,Fatorial.fahrToCelsius(-1.0), 0.2);
	}
	
	
	@Test
	public void testRetornoby32() {
		assertEquals(0.0,Fatorial.fahrToCelsius(32), 0.2);
	}
	
	
}


