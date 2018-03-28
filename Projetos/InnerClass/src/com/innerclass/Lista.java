package com.innerclass;

import java.util.ArrayList;

public class Lista {
	
	private ArrayList<No> nos;

	public Lista() {
		nos = new ArrayList<No>();
		
		nos.add(new No(1));
		nos.add(new No(2));
		nos.add(new No(3));
		nos.add(new No(4));
	}
	
	public int quantidadeValor(){
		return nos.size();
	}
	
	public class No{
		
		private int valor;
		
		public No(int valor){
			this.valor = valor;
		}
		
		public int getValue(){
			return valor;
		}
		
		public void setValue(int valor){
			this.valor = valor;
		}
		
	}

}
