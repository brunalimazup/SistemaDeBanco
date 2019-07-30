package com.br.sistema.banco.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.sistema.banco.models.Cliente;
import com.br.sistema.banco.models.Conta;
import com.br.sistema.banco.services.ClienteService;
import com.br.sistema.banco.services.SistemaService;


@Controller
public class SistemaController {

	@Autowired
	private SistemaService sistemaService;

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/")
	public ModelAndView mostrarCliente() {
		ModelAndView modelAndView = new ModelAndView("index.html");
		modelAndView.addObject("cliente", clienteService.mostrarCliente());
		return modelAndView;
	}

	@GetMapping("/conta")
	public ModelAndView mostrarContas() {
		ModelAndView modelAndView = new ModelAndView("conta.html");
		modelAndView.addObject("cliente", clienteService.mostrarCliente());
		modelAndView.addObject("conta", sistemaService.mostrarConta());
		return modelAndView;
	}
	@GetMapping("/cadastro")
	public ModelAndView mostrarCadastro() {
		ModelAndView modelAndView = new ModelAndView("cadastro.html");
		return modelAndView;
	}

	@PostMapping("/cadastro")
	public ModelAndView cadastrarContas(@Valid Conta conta, BindingResult bindingConta, @Valid Cliente cliente,
			BindingResult bindingCliente) {

		ModelAndView modelAndView = new ModelAndView("cadastro.html");

		if (bindingCliente.hasErrors() || bindingConta.hasErrors()) {
			ArrayList<String> erros = new ArrayList<String>();

			for (ObjectError objectError : bindingCliente.getAllErrors()) {
				erros.add(objectError.getDefaultMessage());
			}
			for (ObjectError objectErros : bindingConta.getAllErrors()) {
				erros.add(objectErros.getDefaultMessage());
			}
			modelAndView.addObject("erros", erros);
		} else {
			modelAndView.addObject("erros", sistemaService.salvarConta(cliente, conta));
		}
		return modelAndView;
	}
}
