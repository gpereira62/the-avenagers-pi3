package br.senac.tads.pi3.gerenprod.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.senac.tads.pi3.gerenprod.db.Database;
import br.senac.tads.pi3.gerenprod.model.Produto;
import br.senac.tads.pi3.gerenprod.dao.ProdutoDao;

public class ProdutoDaoImpl implements ProdutoDao {

	private static ProdutoDaoImpl produtoDaoImpl = null;

	private Connection connection = Database.getConnection();

	public long saveProduto(Produto produto) {
		String sql = "INSERT INTO produtos(NomeProduto, Ano, Modelo, Marca)" 
					+ "VALUES(?,?,?,?)";
		long idProduto = 0;

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, produto.getNomeProduto());
			pstmt.setString(2, produto.getAno());
			pstmt.setString(3, produto.getModelo());
			pstmt.setString(4, produto.getMarca());

			// Creating Produto
			if (pstmt.executeUpdate() > 0) {
				ResultSet rs = pstmt.getGeneratedKeys(); // Returns Generated
															// Primary Key

				if (rs.next())
					idProduto = rs.getLong(1);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return idProduto;
	}

	public void updateProduto(Produto produto) {
		String sql = "UPDATE produtos SET NomeProduto=?, Ano=?, Modelo=?, Marca=?" 
					+ "WHERE idProduto=?";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, produto.getNomeProduto());
			pstmt.setString(2, produto.getAno());
			pstmt.setString(3, produto.getModelo());
			pstmt.setString(4, produto.getMarca());
			pstmt.setLong(5, produto.getIdProduto());

			// Update Produto
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void deleteProduto(Long idProduto) {
		String sql = "DELETE FROM produtos WHERE idProduto=?";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, idProduto);

			// Delete Produto
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public Produto findProdutoById(Long idProduto) {
		String sql = "SELECT * FROM produtos WHERE idProduto=?";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, idProduto);

			// Getting Produto Detail
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				Produto produto = new Produto();
				produto.setIdProduto(resultSet.getLong(1));
				produto.setNomeProduto(resultSet.getString(2));
				produto.setAno(resultSet.getString(3));
				produto.setModelo(resultSet.getString(4));
				produto.setMarca(resultSet.getString(5));

				return produto;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return null;
	}

	public List<Produto> findAllProdutos() {
		String sql = "SELECT * FROM produtos";
		List<Produto> produtos = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);

			// Getting Produtos's Detail
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				if (produtos == null)
					produtos = new ArrayList<>();

				Produto produto = new Produto();
				produto.setIdProduto(resultSet.getLong(1));
				produto.setNomeProduto(resultSet.getString(2));
				produto.setAno(resultSet.getString(3));
				produto.setModelo(resultSet.getString(4));
				produto.setMarca(resultSet.getString(5));

				produtos.add(produto);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return produtos;
	}

	public static ProdutoDao getInstance() {
		if (produtoDaoImpl == null)
			produtoDaoImpl = new ProdutoDaoImpl();

		return produtoDaoImpl;
	}
}
