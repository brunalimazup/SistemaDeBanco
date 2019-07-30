package com.br.sistema.banco.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;

@Entity
public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@DecimalMin(value = "1.0", message = "Adicione um valor a sua conta.")
	private double saldoCorrente;
	@DecimalMin(value = "1.0", message = "Adicione um valor a sua conta.")
	private double saldoPoupanca;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Cliente cliente;

	public Conta() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getSaldoCorrente() {
		return saldoCorrente;
	}

	public void setSaldoCorrente(double saldoCorrente) {
		this.saldoCorrente = saldoCorrente;
	}

	public double getSaldoPoupanca() {
		return saldoPoupanca;
	}

	public void setSaldoPoupanca(double saldoPoupanca) {
		this.saldoPoupanca = saldoPoupanca;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
