package ecommerce.controller;

import java.util.ArrayList;


import ecommerce.model.Produto;
import ecommerce.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {
	
	private ArrayList<Produto> listaProdutos= new ArrayList<Produto>();
	private ArrayList<Produto> listaProdutosVendidos= new ArrayList<Produto>();
	int numero = 0;

	
	//Metodos da lista de produtos
	@Override
	public void procurarPorNumero(int numero) {
		var produto = buscarNaListaProdutos(numero);
		
		if (produto != null ) {
			produto.visualizar(null);
		}else {
			System.out.println("O produto numero: " + numero + " não foi encontrado");
		}
	}

	@Override
	public void listarProdutos() {
		
		if (listaProdutos.isEmpty()) {
			System.out.println("\nA lista de produtos está vazia! ");
		}else {
			
			for (var produto: listaProdutos) {
				produto.visualizar(null);
				
			}
			
		}

	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("\nO produto: " + produto.getNome() + " foi criado com sucesso!");
		
	}
	

	@Override
	public void atualizar(Produto produto) {
		var buscaProduto = buscarNaListaProdutos(produto.getNumero());
		
		if(buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			
		}else {
			//exibe a mensagem de erro do metodo procurarPorNumero
			procurarPorNumero(produto.getNumero());
		}
		
	}

	@Override
	public void deletar(int numero) {
		var produto = buscarNaListaProdutos(numero);
		
		if (produto != null) {
			if (listaProdutos.remove(produto) == true)
				System.out.println("\nO produto numero: " + numero + " foi deletada com sucesso!");
		}else {
			//exibe a mensagem de erro do metodo procurarPorNumero
			procurarPorNumero(produto.getNumero());
		}
	}

	@Override
	public void comprar(int numero) {
		var produto = buscarNaListaProdutos(numero);
		
		if(produto != null) {
			
			cadastrarVendido(produto);
			deletar(numero);
		
			System.out.println("\nAproveite seu novo produto: " + produto.getNome());
			
		}else {
			//exibe a mensagem de erro do metodo procurarPorNumero
			procurarPorNumero(produto.getNumero());
		}
		
	}

	@Override
	public void devolver(int numero) {
		var produto = buscarNaListaVendidos(numero);
		
		if(produto != null) {
			
			cadastrar(produto);
			deletarVendido(numero);
		
			System.out.println("\nO produto: " + produto.getNome() + " foi devolvido");
			
		}else {
			//exibe a mensagem de erro do metodo procurarPorNumero
			procurarPorNumero(produto.getNumero());
		}
		
	}
	
	
	//Métodos da lista de Vendidos
	
	@Override
	public void procurarVendidoPorNumero(int numero) {
		var produto = buscarNaListaVendidos(numero);
		
		if (produto != null ) {
			produto.visualizar(null);
		}else {
			System.out.println("\nO produto numero: " + numero + " não foi encontrado");
		}
	}
	
	
	@Override
	public void listarProdutosVendidos() {
		if (listaProdutosVendidos.isEmpty()) {
			System.out.println("\nA lista de produtos vendidos está vazia! ");
		}else {
			
			for (var produto: listaProdutosVendidos) {
				produto.visualizar(null);
				
			}
			
		}
		
	}
	
	@Override
	public void cadastrarVendido(Produto produto) {
		listaProdutosVendidos.add(produto);
		
	}
	@Override
	public void deletarVendido(int numero) {
		var produto = buscarNaListaVendidos(numero);
		
		if (produto != null) {
			if (listaProdutosVendidos.remove(produto) == true)
				System.out.println("\nO produto numero: " + numero + " foi deletada com sucesso!");
		}else {
			//exibe a mensagem de erro do metodo procurarPorNumero
			procurarPorNumero(produto.getNumero());
		}
		
	}
	
	
	
	
	//Metodos Complementares
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Produto buscarNaListaProdutos(int numero) {
		for(var produto: listaProdutos) {
			if (produto.getNumero() == numero ) {
				return produto;
			}
		}
		return null;
	}
	
	public Produto buscarNaListaVendidos(int numero) {
		for(var produto: listaProdutosVendidos) {
			if (produto.getNumero() == numero ) {
				return produto;
			}
		}
		return null;
	}

	

}
