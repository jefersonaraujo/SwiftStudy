
public class Terceirizado extends Funcionarios {
	
	String empresaOrigem;
	
	
	Terceirizado(int matricula, String nome, String empresaOrigem) {
		setMatricula(matricula);
		setNome(nome);
		setEmpresaOrigem(empresaOrigem);
		
	}


	public String getEmpresaOrigem() {
		return empresaOrigem;
	}


	public void setEmpresaOrigem(String empresaOrigem) {
		this.empresaOrigem = empresaOrigem;
	}

}
