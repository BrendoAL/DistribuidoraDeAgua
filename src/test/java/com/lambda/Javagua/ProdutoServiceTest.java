package com.lambda.Javagua;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lambda.Javagua.DTOS.ProdutoCreateDTO;
import com.lambda.Javagua.DTOS.ProdutoDTO;
import com.lambda.Javagua.Model.Fornecedor;
import com.lambda.Javagua.Model.Produto;
import com.lambda.Javagua.Repositoy.FornecedorRepository;
import com.lambda.Javagua.Repositoy.ProdutoRepository;
import com.lambda.Javagua.Service.ProdutoService;

public class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService produtoService;

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private FornecedorRepository fornecedorRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    

    @Test
    void testSalvarProdutoViaDTO() {
        ProdutoCreateDTO dto = new ProdutoCreateDTO();
        dto.setNome("Água 20L");
        dto.setTamanho("20L");
        dto.setDataFabricacao(LocalDate.now());
        dto.setValidade(LocalDate.now().plusDays(30));
        dto.setPreco(15.0);
        dto.setEstoque(50);
        dto.setFornecedorId(1L);

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(1L);

        Produto produtoSalvo = new Produto();
        produtoSalvo.setId(1L);
        produtoSalvo.setNome(dto.getNome());
        produtoSalvo.setFornecedor(fornecedor);

        //retorno
        when(fornecedorRepository.findById(1L)).thenReturn(Optional.of(fornecedor));
        when(produtoRepository.save(any(Produto.class))).thenReturn(produtoSalvo);

        ProdutoDTO result = produtoService.salvarProduto(dto);

        assertNotNull(result);
        assertEquals("Água 20L", result.getNome());
        verify(fornecedorRepository, times(1)).findById(1L);
        verify(produtoRepository, times(1)).save(any(Produto.class));
    }
    
    @Test
    void testListarProduto() {
    	Produto produto1 = new Produto();
    	produto1.setId(1L);
    	Produto produto2 = new Produto();
    	produto2.setId(2L);
    	
    	//retorno
    	when(produtoRepository.findAll()).thenReturn(Arrays.asList(produto1, produto2));
    	
    	List<Produto> produtos = produtoService.listarProduto();
    	
    	assertEquals(2, produtos.size());
    	verify(produtoRepository, times(1)).findAll();
    }
    
    @Test
    void testDeletarProduto() {
        Long id = 1L;

        //retorno
        doNothing().when(produtoRepository).deleteById(id);

        produtoService.deletarProduto(id);

        verify(produtoRepository, times(1)).deleteById(id);
    }
    
    @Test
    void testBuscarProdutoPorId() {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Água sem gás");

        //retorno
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        ProdutoDTO result = produtoService.buscarProdutoPorId(1L);

        assertNotNull(result);
        assertEquals("Água sem gás", result.getNome());
        verify(produtoRepository, times(1)).findById(1L);
    }
}
