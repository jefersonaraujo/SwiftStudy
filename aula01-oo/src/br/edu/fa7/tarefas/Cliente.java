package br.edu.fa7.tarefas;

public class Cliente {

	public static void main(String[] args) {
		Carro c = new Carro();
		System.out.println(c.getNumeroDePneus());
		//Transporte v = new Transporte(); nao compila
		Transporte c2 = new Carro(); 
		System.out.println(c2.getNumeroDePneus());
	}

}
