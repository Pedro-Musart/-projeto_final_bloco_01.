package ecommerce.repository;

import ecommerce.model.Produto;

public interface ProdutoRepository {

	public void procurarPorNumero(int numero);
	
	// CRUD do Produto
	
	public void listarTodas();
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int numero);
	
	// Métodos cliente
	public void comprar (int numero, float valor);
	public void devolver (int numero, float valor);
	
	
}
