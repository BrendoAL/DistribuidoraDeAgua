package com.lambda.Javagua.DTOS;

import com.lambda.Javagua.Model.Produto;

public class ProdutoDTO {

	private Long id;
	private String nome;
	private String tamanho;
	private String dataFabricacao;
	private String validade;
	private double preco;

	// Construtores

	public ProdutoDTO() {
	}

	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.tamanho = produto.getTamanho();
		this.dataFabricacao = produto.getDataFabricacao();
		this.validade = produto.getValidade();
		this.preco = produto.getPreco();
	}

	// Getters e Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setFornecedorId(Long id2) {
		// TODO Auto-generated method stub
		
	}
}
