package com.pizzeria.id.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzeria.id.model.DetalleOrden;

public interface ICrudDetalleOrden extends JpaRepository<DetalleOrden, Integer>{

}
