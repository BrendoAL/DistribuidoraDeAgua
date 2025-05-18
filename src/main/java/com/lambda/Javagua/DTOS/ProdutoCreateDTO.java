package com.lambda.Javagua.DTOS;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class ProdutoCreateDTO {
	@NotBlank(message = "O nome não pode ficar em branco.")
    private String nome;
	@NotEmpty
    private String tamanho;
    private LocalDate dataFabricacao;
    private LocalDate validade;
	@Positive
    private double preco;
	@PositiveOrZero
	private Integer estoque;
	
    public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	private Long fornecedorId; 

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

    public @Past LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(@Past(message = "A data não pode ser no futuro.") LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(@Future(message = "A data não pode ser no passado") LocalDate validade) {
        this.validade = validade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Long getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Long fornecedorId) {
        this.fornecedorId = fornecedorId;
    }
}
