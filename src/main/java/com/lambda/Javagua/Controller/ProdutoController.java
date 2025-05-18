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

import com.lambda.Javagua.DTOS.ProdutoCreateDTO;
import com.lambda.Javagua.DTOS.ProdutoDTO;
import com.lambda.Javagua.Model.Produto;
import com.lambda.Javagua.Service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<Produto> listarProdutos() {
		return produtoService.listarProduto();
	}

	@PostMapping
	public ProdutoDTO criarProduto(@Valid @RequestBody ProdutoCreateDTO dto) {
	    return produtoService.salvarProduto(dto);
	}
	
	@GetMapping("/{id}")
    public ProdutoDTO buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.buscarProdutoPorId(id);	
    }
	
	@DeleteMapping("/{id}")
	public void deletarProduto(@PathVariable Long id) {
		produtoService.deletarProduto(id);
	}
}
