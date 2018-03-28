package com.example.appmoney;

import java.io.Serializable;

public class Conta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static enum TIPO {DESPEZA, RECEITA};
	
	private double valor;
	private TIPO tipo;
	
	public Conta(double valor, TIPO tipo) {
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public double getValor() {
		return valor;
	}
	
	public TIPO getTipo() {
		return tipo;
	}
	
}
