
public class Funcionarios {

	private int matricula;
	private String nome;
	
	
	Funcionarios( ) {
		
		
	}
	

	//Construtor do Matricula
	Funcionarios(int matricula) {
		this.matricula = matricula;
		
	}
	
	//Construtor do Matricula e nome, que chama o contrutor acima
	Funcionarios(int matricula, String nome) {
		this(matricula);
		this.nome = nome;
		
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
