package br.com.diegooli.powerball;

public class Data {
	
	 int dia;
	    int mes;
	    int ano;
	    
	    void exibir() {
	     //   System.out.print(dia + "/"+ mes + "/"+ ano);
	    	StringBuilder a = new StringBuilder();
	        a.append(dia).append("/").append(mes).append("/").append(ano);
	        System.out.println(a.toString());
	        
	    }
	    
	    
	Data() {
	        
	        ano = 2018;
	            
	        }

	Data(int numeroAno) {
	        
	        ano = numeroAno;
	            
	        }

	    Data(int dia, int mes, int ano) {
	        this();
	        this.dia = dia;
	        this.mes = mes;
	       
	            
	        }
	    
	    //sobrecarga de metodos
	    
	    void Data1(int i, int j) {
	        
	        System.out.println("primeiro metodo");
	        
	    }
	    
	void Data1(int j) {
	        
	    System.out.println("metodo sobrecarga");
	        
	    }





	    
	    int diasDoAno() {
	        int dias = 0;
	        
	        return dias;
	    }

	int incrementarAno (int quantidade) {
	    ano += quantidade;
	    return ano;
	}



	    


}
