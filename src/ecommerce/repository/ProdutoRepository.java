package ecommerce.repository;

import ecommerce.model.Produto;

public interface ProdutoRepository {

	public void procurarPorNumero(int numero);
	
	// CRUD do Produto
	public void listarProdutos();
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int numero);
	
	// Métodos cliente
	public void comprar (int numero);
	public void devolver (int numero);
	
	// Lista de vendidos
	public void procurarVendidoPorNumero(int numero);
	public void listarProdutosVendidos();
	public void cadastrarVendido(Produto produto);
	public void deletarVendido(int Numero);
	
}
