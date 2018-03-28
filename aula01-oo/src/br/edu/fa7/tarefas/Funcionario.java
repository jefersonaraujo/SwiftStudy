package br.edu.fa7.tarefas;

import java.util.Date;

public class Funcionario {
	String nome;
	int Matricula;
	char sexo;
	Date date = new Date();
	
	void recebeSalario(){
		System.out.println("recebendo um salario minimo");
	}
	
	void realizaAcao(Funcionario f){
		if(f.getClass().getName()=="Professor"){
			
		}else if(f.getClass().getName()=="Coordenador"){
			
		}
	}
	
}


