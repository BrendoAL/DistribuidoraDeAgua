package com.lambda.Javagua.DTOS;

import java.time.LocalDate;

import com.lambda.Javagua.Model.Produto;

public class ProdutoDTO {

	private Long id;
	private String nome;
	private String tamanho;
	private LocalDate dataFabricacao;
	private LocalDate validade;
	private double preco;
	private Integer estoque;

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public ProdutoDTO() {
	}

	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.tamanho = produto.getTamanho();
		this.dataFabricacao = produto.getDataFabricacao();
		this.validade = produto.getValidade();
		this.preco = produto.getPreco();
		this.estoque = produto.getEstoque();
	}

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

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate localDate) {
		this.validade = localDate;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setFornecedorId(Long id2) {
	}
}
