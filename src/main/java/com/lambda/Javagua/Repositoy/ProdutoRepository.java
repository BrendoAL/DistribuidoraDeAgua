package com.lambda.Javagua.Repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lambda.Javagua.Model.Produto;

	public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
