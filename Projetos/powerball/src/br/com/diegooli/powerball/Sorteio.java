package br.com.diegooli.powerball;


public class Sorteio {
	
	 private int[] resultado = new int[6];  

	  public void sortearResutados() {  
	     for(int i = 0; i < resultado.length - 1; i++) {  
	        int sorteado = 0;  
	        do {  
	           sorteado = sortear("branco");  
	        } while(isRepetido(sorteado)) ; 
	        resultado[i]=sorteado;  
	        
	     }  
	     resultado[5] = sortear("vermelho");
	  }

	  public boolean isRepetido(int sorteado) {  
	     for (int i = 0; i < resultado.length - 1; i++)  
	         if (resultado[i] == sorteado )  
	            return true;  
	     return false;  
	  } 

	  public int sortear(String cor) {  
		  if (cor == "vermelho")			 		
	     return (int) (Math.random()*42+1);  
		  else 
			  return (int) (Math.random()*49+1);
	  } 
	  
	
	  
	  public void getResultado() { 
		  System.out.println("Bolas brancas:");
		  for(int i = 0; i < resultado.length; i++) {  
			  if (i == 5) 
		    	   System.out.println("Bola vermelha");
		       System.out.println(resultado[i]);
		      
		       
		  }
		 
	  }
	  
	public static void main (String[] args) {
	
		

	Sorteio a = new Sorteio();
	a.sortearResutados();
	a.getResultado();
	
			
		
		
		
	}
}
