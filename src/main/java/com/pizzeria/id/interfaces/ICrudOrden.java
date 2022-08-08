package com.pizzeria.id.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzeria.id.model.Cliente;
import com.pizzeria.id.model.Orden;

public interface ICrudOrden extends JpaRepository<Orden, Integer>{
	
}
