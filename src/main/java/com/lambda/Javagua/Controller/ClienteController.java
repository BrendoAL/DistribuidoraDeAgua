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

import com.lambda.Javagua.DTOS.ClienteCreateDTO;
import com.lambda.Javagua.DTOS.ClienteDTO;
import com.lambda.Javagua.Model.Cliente;
import com.lambda.Javagua.Service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> listarClientes() {
		return clienteService.listarClientes();
	}
	
	@PostMapping
    public ClienteDTO criarCliente(@Valid @RequestBody ClienteCreateDTO dto) {
        return clienteService.salvarCliente(dto);
    }

    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCLiente(id);
    }
}
