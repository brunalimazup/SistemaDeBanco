package com.br.sistema.banco.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.sistema.banco.models.Conta;
@Repository
public interface SistemaRepository extends CrudRepository<Conta, Integer> {

}
