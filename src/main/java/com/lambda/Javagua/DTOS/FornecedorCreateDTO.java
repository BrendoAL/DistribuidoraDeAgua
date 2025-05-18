package com.lambda.Javagua.DTOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FornecedorCreateDTO {

	@NotBlank(message = "A marca não pode ficar em branco.")
	private String marca;
	@Size(min= 14, max=14)
	private String cnpj;

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