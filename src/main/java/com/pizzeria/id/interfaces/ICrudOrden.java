package com.pizzeria.id.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzeria.id.model.Orden;

public interface ICrudOrden extends JpaRepository<Orden, Integer>{

}
