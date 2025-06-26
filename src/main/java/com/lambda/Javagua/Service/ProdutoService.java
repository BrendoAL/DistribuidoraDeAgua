package com.lambda.Javagua.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambda.Javagua.DTOS.ProdutoCreateDTO;
import com.lambda.Javagua.DTOS.ProdutoDTO;
import com.lambda.Javagua.Model.Fornecedor;
import com.lambda.Javagua.Model.Produto;
import com.lambda.Javagua.Repositoy.FornecedorRepository;
import com.lambda.Javagua.Repositoy.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;

	public List<Produto> listarProduto() {
		return produtoRepository.findAll();
	}
	
	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public void deletarProduto(Long id) {
		produtoRepository.deleteById(id);
	}
	
	public ProdutoDTO buscarProdutoPorId(Long id) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado ID: " + id));
		
		return converterParaDTO(produto);
	}
	
	private ProdutoDTO converterParaDTO(Produto produto) {
	    ProdutoDTO dto = new ProdutoDTO();
	    dto.setId(produto.getId());
	    dto.setNome(produto.getNome());
	    dto.setTamanho(produto.getTamanho());
	    dto.setDataFabricacao(produto.getDataFabricacao());
	    dto.setValidade(produto.getValidade());
	    dto.setPreco(produto.getPreco());
	    dto.setEstoque(produto.getEstoque());

	    if (produto.getFornecedor() != null) {
	        dto.setFornecedorId(produto.getFornecedor().getId());
	    }

	    return dto;
	}
	
	public ProdutoDTO salvarProduto(ProdutoCreateDTO dto) {
	    Produto produto = new Produto();

	    produto.setNome(dto.getNome());
	    produto.setTamanho(dto.getTamanho());
	    produto.setDataFabricacao(dto.getDataFabricacao());
	    produto.setValidade(dto.getValidade());
	    produto.setPreco(dto.getPreco());
	    produto.setEstoque(dto.getEstoque());
	    
	    Fornecedor fornecedor = fornecedorRepository.findById(dto.getFornecedorId())
	            .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

	        produto.setFornecedor(fornecedor);

	        Produto salvo = produtoRepository.save(produto);

	        return converterParaDTO(salvo);
	}	
	
	public ProdutoDTO atualizarProduto(Long id, ProdutoCreateDTO dto) {
	    Produto produto = produtoRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Produto não encontrado ID: " + id));

	    produto.setNome(dto.getNome());
	    produto.setTamanho(dto.getTamanho());
	    produto.setDataFabricacao(dto.getDataFabricacao());
	    produto.setValidade(dto.getValidade());
	    produto.setPreco(dto.getPreco());
	    produto.setEstoque(dto.getEstoque());

	    Fornecedor fornecedor = fornecedorRepository.findById(dto.getFornecedorId())
	            .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

	    produto.setFornecedor(fornecedor);

	    Produto atualizado = produtoRepository.save(produto);

	    return converterParaDTO(atualizado);
	}

}
