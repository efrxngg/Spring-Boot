package com.pizzeria.id.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzeria.id.model.Cliente;

public interface ICrudCliente extends  JpaRepository<Cliente, Integer>{

}
