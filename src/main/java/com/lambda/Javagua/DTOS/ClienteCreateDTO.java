package com.lambda.Javagua.DTOS;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClienteCreateDTO {

	@NotBlank(message = "O nome não pode estar em branco.")
	private String nome;
	@Size(min=8, max=8)
	private String cep;
	@Email(message = "Email inválido.")
	private String email;
	@Pattern(regexp="\\d{11}", message = "O telefone é obrigatório.")
	private String telefone;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
