package ecommerce.model;

public class Instrumento extends Produto {

	public Instrumento(int numero, String nome, int tipo, int variacao, float preco) {
		super(numero, nome, tipo, variacao, preco);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void visualizar(String variacao) {
		String nomeVariacao = "";
		
		switch(this.getVariacao()) {
		case 1:
			nomeVariacao = "Percurssão";
			break;
		case 2:
			nomeVariacao = "Corda";
			break;
		case 3:
			nomeVariacao = "Sopro";
			break;
		case 4:
			nomeVariacao = "Teclas";
			break;
		}
		super.visualizar(nomeVariacao);
		
		
		
	}
	



}
