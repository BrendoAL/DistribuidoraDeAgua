package com.lambda.Javagua.DTOS;

import com.lambda.Javagua.Model.Fornecedor;

public class FornecedorDTO {

	private Long id;
	private String marca;
	private String cnpj;

	public FornecedorDTO(Fornecedor fornecedor) {
		this.id = fornecedor.getId();
		this.marca = fornecedor.getMarca();
		this.cnpj = fornecedor.getCnpj();
	}

	public FornecedorDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
