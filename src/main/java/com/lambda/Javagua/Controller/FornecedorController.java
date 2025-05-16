package com.lambda.Javagua.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lambda.Javagua.DTOS.FornecedorCreateDTO;
import com.lambda.Javagua.DTOS.FornecedorDTO;
import com.lambda.Javagua.Model.Fornecedor;
import com.lambda.Javagua.Service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;

	@GetMapping
	public List<Fornecedor> listarFornecedor() {
		return fornecedorService.listarFornecedor();
	}

	@PostMapping
	public FornecedorDTO criarFornecedor(@RequestBody FornecedorCreateDTO dto) {
		return fornecedorService.criarFornecedor(dto);
	}

	@DeleteMapping("/{id}")
	public void deletarFornecedor(@PathVariable Long id) {
		fornecedorService.deletarFornecedor(id);
	}

	@GetMapping("/{id}")
	public Fornecedor buscarFornecedorPorId(@PathVariable Long id) {
		return fornecedorService.buscarFornecedorPorId(id);
	}
}
