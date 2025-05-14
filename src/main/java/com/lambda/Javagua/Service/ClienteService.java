package com.lambda.Javagua.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambda.Javagua.Model.Cliente;
import com.lambda.Javagua.Repositoy.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepositoy;

	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepositoy.save(cliente);
	}
	
	public Cliente buscarClientePorId(Long id) {
        return clienteRepositoy.findById(id).orElse(null);
    }
	
	public List<Cliente> listarClientes() {
		return clienteRepositoy.findAll();
	}

	public void deletarCLiente(Long id) {
		clienteRepositoy.deleteById(id);
	}
}
