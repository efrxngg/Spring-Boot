package com.pizzeria.id.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzeria.id.model.ProductoDetalleOrden;

public interface ICrudProductoDetalleOrden extends JpaRepository<ProductoDetalleOrden, Integer>{

}
