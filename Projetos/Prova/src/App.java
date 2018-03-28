
public class App {
	
	public static void main(String[] args) {
		
		Funcionarios func = new Funcionarios();
		Terceirizado terc = new Terceirizado(2, "carlo", "Empresa 1");
		
		func.setMatricula(1);
		func.setNome("Dario");
		
		
		StringBuilder funci = new StringBuilder();
		StringBuilder terci = new StringBuilder();
		
        funci.append(func.getMatricula()).append(" ").append(func.getNome());
        terci.append(terc.getMatricula()).append(" ").append(terc.getNome());
        System.out.println(funci.toString());
        System.out.println(terci.toString());
        
        
		
		
		
	}

}
