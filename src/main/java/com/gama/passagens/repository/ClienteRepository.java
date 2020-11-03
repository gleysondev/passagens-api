package com.gama.passagens.repository;

import org.springframework.data.repository.CrudRepository;

import com.gama.passagens.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	Cliente findByUsuarioLogin(String login);
	
}
