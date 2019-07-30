package com.br.sistema.banco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sistema.banco.models.Cliente;
import com.br.sistema.banco.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Iterable<Cliente> mostrarCliente(){
		return clienteRepository.findAll();
	}

}
