package com.lambda.Javagua.Repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lambda.Javagua.Model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
