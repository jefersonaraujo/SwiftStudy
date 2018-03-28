package br.com.diegooli.Elevador;


public class Elevador {
	
	public static int capacidadeMaxima;
	public static int andarTerreo;
	public static int cobertura;
	private int numeroOcupantes;
	private int andarAtual;
	private boolean  portaAberta;
	
	
	Elevador() {
		this.cobertura = 10;
		this.andarTerreo = 0;
		this.capacidadeMaxima = 20;
	}
	
	
	
	public int getAndarAtual() {
		return andarAtual;
	}



	public void setAndarAtual(int andarAtual) {
		this.andarAtual = andarAtual;
	}



	public int getNumeroOcupantes() {
		return numeroOcupantes;
	}



	public void setNumeroOcupantes(int numeroOcupantes) {
		this.numeroOcupantes = numeroOcupantes;
	}



	public void abrirPorta() {
		portaAberta = true;
		System.out.println( "Porta se abrindo" );
	}
	
	public void fecharPorta() {
		portaAberta = false;
		System.out.println( "Porta se fechando" );
	}

	public void subirPara(int andar) {
		
		if (portaAberta == true ) {
			System.out.println("elevador nao se move, pois a porta esta aberta.");
			
				
			}
		
		
		
		else {
			for (int subir = andarAtual  ; subir >= andar; subir--){  
                
				StringBuilder locomocao = new StringBuilder();
				locomocao.append("Descendo...").append(" andar: ").append(subir);
		        System.out.println(locomocao.toString());
                
             }  
			
			abrirPorta();
			
		}
	
	
	}
	

	public void descerPara(int andar) {
			
		
		if (portaAberta == true) {
			System.out.println("elevador nao se move, pois a porta esta aberta.");
			
			
		}
		else if (andarTerreo == andar) {
			
		}
			else {
				
				for (int descer = andarAtual  ; descer >= andar; descer--){  
	                
					StringBuilder locomocao = new StringBuilder();
					locomocao.append("Descendo...").append(" andar: ").append(descer);
			        System.out.println(locomocao.toString());
	                
	             }  
				abrirPorta();
				
				
                    }  
	}
				
			
				
	
		
		public void entrarPessoa() {
			
			this.numeroOcupantes ++;
			
			
			System.out.println( "Entrando uma pessoa." + " Elevador possui "+  numeroOcupantes + " pessoas");
			
		}
		
		public void sairPessoa() {
			abrirPorta();
			this.numeroOcupantes --;
			System.out.println( "Saindo uma pessoa." + " Elevador possui "+  numeroOcupantes + " pessoas");
			fecharPorta();
		}
		
}

