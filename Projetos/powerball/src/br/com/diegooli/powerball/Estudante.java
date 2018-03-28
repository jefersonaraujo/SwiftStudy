package br.com.diegooli.powerball;

public class Estudante {
	
	  int matricula;
	    String nome;
	    char sexo;
	    double[] notas = new double[4]; 
	    
	    
	    Estudante() {
	    	
	    	nome = "";
	    	
	    }
	    
	    
	    void exibir() {
	    	
	    	matricula = 23;
	    	nome = "diego;";
	    	StringBuilder builder = new StringBuilder();
	    	builder.append(matricula).append(",");
	    	builder.append(nome);
	    	builder.append(sexo);
	    	System.out.println(builder.toString());

	        
	        
	    }
	    
	    void atribuirNota(int numProva, double notas) {
	    	
	        this.notas[numProva] = notas;
	        
	        
	    }
	    
	    void lerNota(int numProva) {
	    	
	        System.out.println(notas[numProva]);
	        
	        
	    }

}
