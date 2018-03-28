package br.edu.fa7.tarefas;

public class Estudante {
	
	int matricula;
	String nome;
	char sexo;
	double notas[] = new double[4];
	
	Estudante(){
		matricula=000;
		nome="Pessoa";
		sexo='M';
		
	}
	
	Estudante(String n,char s){
		nome=n;
		sexo=s;
	}

	Estudante(String n,char s,int m){
		nome=n;
		sexo=s;
		matricula=m;
	}	
	
	void exibir(){
		System.out.println("Matricula = "+ matricula);
		System.out.println("Nome = "+ nome);
		System.out.println("Sexo = "+ sexo);
		for(int i=0;i<=3;i++){
			System.out.println("Nota"+i+": "+notas[i]);
		}
	}
	
	void exibir(String titulo){
		System.out.println(titulo);
		exibir();
	}

	void atribuirNota(int numProva, double nota){
		notas[numProva-1]=nota;
	}
	
	void atribuirNota(int indice){
		notas[indice-1]=0.0;
	}
	
	double lerNota(int numProva){
		return notas[numProva-1];
	}
}
