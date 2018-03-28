package br.edu.fa7.tarefas;

abstract class Aparelho {
	abstract void ligar();
	abstract void desligar();
	void exibir(){
		System.out.println("Aparelho esta exibindo algo.");
	}
}