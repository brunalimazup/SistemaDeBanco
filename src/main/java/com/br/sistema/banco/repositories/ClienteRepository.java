package com.br.sistema.banco.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.sistema.banco.models.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}