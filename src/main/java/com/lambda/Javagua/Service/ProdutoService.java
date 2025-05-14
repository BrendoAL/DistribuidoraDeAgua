package com.lambda.Javagua.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambda.Javagua.Model.Produto;
import com.lambda.Javagua.Repositoy.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> listarProduto() {
		return produtoRepository.findAll();
	}
	
	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public void deletarProduto(Long id) {
		produtoRepository.deleteById(id);
	}
	
	public Produto buscarProdutoPorId(Long id) {
		return produtoRepository.findById(id).orElse(null);
	}
}
