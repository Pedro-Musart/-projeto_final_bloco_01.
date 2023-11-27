package ecommerce.model;

public class Musica extends Produto {

	public Musica(int numero, String nome, int tipo, int variacao, float preco) {
		super(numero, nome, tipo, variacao, preco);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visualizar(String variacao) {
		String nomeVariacao = "";
		
		switch(this.getVariacao()) {
		case 1:
			nomeVariacao = "CD";
			break;
		case 2:
			nomeVariacao = "Vinil";
			break;
		}
		super.visualizar(nomeVariacao);
		
		
		
	}

}
