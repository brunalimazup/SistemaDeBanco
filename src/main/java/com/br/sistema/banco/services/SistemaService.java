package com.br.sistema.banco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sistema.banco.models.Cliente;
import com.br.sistema.banco.models.Conta;
import com.br.sistema.banco.repositories.SistemaRepository;

@Service
public class SistemaService {

	@Autowired
	private SistemaRepository sistemaRepository;

	public Iterable<Conta> mostrarConta() {
		return sistemaRepository.findAll();
	}

	public String salvarConta(Cliente cliente, Conta conta) {
		if (conta.getSaldoPoupanca() >= 100 || conta.getSaldoCorrente() >= 100) {
			conta.setCliente(cliente);
			sistemaRepository.save(conta);
			return "Conta criada com sucesso!";
		} else {
			return "Seu saldo é insuficiente para criar uma conta.";
		}
	}
}
