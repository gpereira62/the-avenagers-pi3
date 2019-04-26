package br.senac.tads.pi3.gerenprod.model;

public class Produto {
	private Long idProduto;
	private String NomeProduto;
	private String Ano;
	private String Modelo;
	private String Marca;

	public Produto() {
		// Do Nothing
	}

	public Produto(String nomeProduto, String ano, String modelo, String marca) {
		this.NomeProduto = nomeProduto;
		this.Ano = ano;
		this.Modelo = modelo;
		this.Marca = marca;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return NomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.NomeProduto = nomeProduto;
	}

	public String getAno() {
		return Ano;
	}

	public void setAno(String ano) {
		this.Ano = ano;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		this.Modelo = modelo;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		this.Marca = marca;
	}
}
