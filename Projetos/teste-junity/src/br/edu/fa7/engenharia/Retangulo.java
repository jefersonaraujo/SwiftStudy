package br.edu.fa7.engenharia;

public class Retangulo {

	private double base;
	
	private double altura;
	
	public Retangulo() {

	}

	public Retangulo(double base, double altura) {
		super();
		setBase(base);
		setAltura(altura);
	}

	
	
	
	/**
	 * @return the base
	 */
	public double getBase() {
		return base;
	}

	/**
	 * @param base the base to set
	 */
	public void setBase(double base) {
		if(base <= 0){
			throw new IllegalArgumentException("Valor inválido para base");
		}
		
		this.base = base;
	}

	/**
	 * @return the altura
	 */
	public double getAltura() {
		return altura;
	}

	/**
	 * @param altura the altura to set
	 */
	public void setAltura(double altura) {
		if(altura <= 0){
			throw new IllegalArgumentException("Valor inválido para altura");
		}
		
		this.altura = altura;
	}

	
	public double calcularArea(){
		
		return base * altura;
		
	}
	
	@Override
	public String toString(){
		
		return "{base : " + base + ", altura : " + altura + "}";
		
	}
	
	
	
	
}
