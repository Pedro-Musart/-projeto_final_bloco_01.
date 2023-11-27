package ecommerce.model;

import ecommerce.util.Cores;

public abstract class Produto {
	

	private int numero;
	private String nome;
	private int tipo;
	private int variacao;
	private float preco;
	
	
	public Produto(int numero, String nome, int tipo, int variacao, float preco) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.tipo = tipo;
		this.variacao = variacao;
		this.preco = preco;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public int getVariacao() {
		return variacao;
	}


	public void setVariacao(int variacao) {
		this.variacao = variacao;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
	public void visualizar(String variacao) {
		String tipo = "";
		
		switch(this.tipo) {
		case 1:
			tipo = "Instrumentos";
			break;
		case 2:
			tipo = "Musica - Midia Fisica";
			break;
			
			
		}
		
		System.out.println(Cores.TEXT_RED +"\n\n***********************************************************");
		System.out.println(Cores.TEXT_WHITE +"Dados do Produto:");
		System.out.println(Cores.TEXT_RED + "***********************************************************");
		System.out.println(Cores.TEXT_WHITE + "Nome do Produto: " + this.nome);
		System.out.println("Numero do Produto: " + this.numero);
		System.out.println("Categoria: " + tipo);
		System.out.println("Variação: " + variacao);
		System.out.println("Preco: " + this.preco);
	}
}
