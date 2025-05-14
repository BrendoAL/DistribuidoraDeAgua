package com.lambda.Javagua.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambda.Javagua.Model.Fornecedor;
import com.lambda.Javagua.Repositoy.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public List<Fornecedor> listarFornecedor() {
		return fornecedorRepository.findAll();
	}
	
	public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}
	
	public void deletarFornecedor(Long id) {
		fornecedorRepository.deleteById(id);
	}
	
	public Fornecedor buscarFornecedorPorId (Long id) {
		return fornecedorRepository.findById(id).orElse(null);
	}
}
