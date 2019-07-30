package com.br.sistema.banco.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull (message = "O campo nome é obrigatório.")
	@NotBlank
	private String nome;
	@NotNull (message = "O campo do cpf é obrigatório.")
	@NotBlank
	@Size (min = 14, max = 14 , message = "O campo do cpf deve conter pontos e traços.")
	private String cpf;
	@NotNull (message = "O campo do telefone é obrigatório.")
	@NotBlank
	@Size (min = 15, max = 15, message = "O campo do telefone deve ter o ddd entre () e o número com traço. ")
	private String telefone;
		
	@OneToOne(mappedBy = "cliente")
	private Conta conta;
	
	public Cliente () {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
