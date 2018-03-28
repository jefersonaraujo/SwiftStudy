package br.com.diegooli.Elevador;


public class App  {
	
	public static void main(String[] args) {
//		
//		ContaCorrente c1 = new ContaCorrente(1, 200);
//		ContaEspecial c2 = new ContaEspecial();
//		
//		ContaCorrente c3 = c2;
//		
//		c1.debitar(100);
//		c2.debitar(100);;
//		c3.debitar(100);
//		c1.getSaldo();
//		
//		
		
		
		Elevador e1 = new Elevador();
		
		e1.entrarPessoa();
		e1.setAndarAtual(7);
		e1.descerPara(3);
		e1.subirPara(8);
	
		
	}

}
