import java.util.ArrayList;


public class Empresa {
	
	private String nome;
	private  ArrayList<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
	

	
	public void admitirFuncionarios(Funcionarios funcionario) {
		 {
		funcionarios.add(funcionario)	;
			
		}
		
	}
	
	public void demitirFuncionariod(int matricula) {
		
		funcionarios.remove(matricula);
	}
	
	public void pagarFuncionarios() {
		
		
	}
	
	
	
}
