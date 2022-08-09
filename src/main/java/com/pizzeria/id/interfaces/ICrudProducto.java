package com.pizzeria.id.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzeria.id.model.Producto;

public interface ICrudProducto extends JpaRepository<Producto, Integer>{

}
