package br.edu.fa7.tarefas;

public class TesteFuncionarios {

	public static void main(String[] args) {
		Funcionario f = new Funcionario();
		f.recebeSalario();
		System.out.println(f.getClass().getName());
		
		f = new Professor();
		f.recebeSalario();
		System.out.println(f.getClass().getName());
		
		f = new Contador();
		((Contador)f).contabilidade();
		f.recebeSalario();
		System.out.println(f.getClass().getName());
		
		f = new Coordenador();
		((Professor)f).leciona();
		if(f instanceof Contador){
			((Contador)f).contabilidade();
		}else{
			System.out.println("Nao faco contas");
		}		
		f.recebeSalario();
		System.out.println(f.getClass().getName());		
		
	}

}
