package com.lambda.Javagua.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambda.Javagua.DTOS.FornecedorCreateDTO;
import com.lambda.Javagua.DTOS.FornecedorDTO;
import com.lambda.Javagua.Model.Fornecedor;
import com.lambda.Javagua.Repositoy.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public List<Fornecedor> listarFornecedor() {
		return fornecedorRepository.findAll();
	}
	
	public FornecedorDTO criarFornecedor(FornecedorCreateDTO dto) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setMarca(dto.getMarca());
        fornecedor.setCnpj(dto.getCnpj());
        fornecedor = fornecedorRepository.save(fornecedor);

        return new FornecedorDTO(fornecedor);
    }
	
	public void deletarFornecedor(Long id) {
		fornecedorRepository.deleteById(id);
	}
	
	public Fornecedor buscarFornecedorPorId (Long id) {
		return fornecedorRepository.findById(id).orElse(null);
	}
}
