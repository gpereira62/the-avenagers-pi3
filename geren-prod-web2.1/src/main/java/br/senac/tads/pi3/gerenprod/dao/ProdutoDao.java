package br.senac.tads.pi3.gerenprod.dao;

import java.util.List;

import br.senac.tads.pi3.gerenprod.model.Produto;

public interface ProdutoDao {
	long saveProduto(Produto produto);

	void updateProduto(Produto produto);

	void deleteProduto(Long idProduto);

	Produto findProdutoById(Long idProduto);

	List<Produto> findAllProdutos();
}
