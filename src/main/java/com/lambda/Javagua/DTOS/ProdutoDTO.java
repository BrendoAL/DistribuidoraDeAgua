package com.lambda.Javagua.DTOS;

import com.lambda.Javagua.Model.Produto;

public class ProdutoDTO {

	private String nome;
    private double preco;

    // construtor
    public ProdutoDTO(Produto produto) {
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
    }
}
