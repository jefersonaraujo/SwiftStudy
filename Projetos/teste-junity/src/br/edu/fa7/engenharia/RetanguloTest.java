package br.edu.fa7.engenharia;

import static org.junit.Assert.*;

import org.junit.Test;

public class RetanguloTest {

	@Test
	public void test() {
		
		Retangulo retangulo = new Retangulo(3, 2);
		double area = retangulo.calcularArea();
		assertEquals(6.0, area, 0.1);;
	}
	
	@Test
	public void testBaseZero() {
		
		try{
			
			Retangulo retangulo = new Retangulo(0.0, 2);
			fail("Valor inválido para base");
	
		} catch (Exception e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testAlturaZero() {
		
		try{
			
			Retangulo retangulo = new Retangulo(3, 0.0);
			fail("Valor inválido para base");
	
		} catch (Exception e){
			assertTrue(true);
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValoresNegativos() {
		
		Retangulo retangulo = new Retangulo(3, -2.0);
		fail("Valor inválido para base");
		
		retangulo = new Retangulo(-3, +2.0);
		fail("Valor inválido para base");
		
		retangulo = new Retangulo(-3, -2.0);
		fail("Valor inválido para base");
	
	}
}
