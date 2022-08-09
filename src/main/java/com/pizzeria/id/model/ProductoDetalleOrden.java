package com.pizzeria.id.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto_detalle_orden")
public class ProductoDetalleOrden implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	@Column(name = "fk_detalle_orden")
	private Integer fk_detalle_orden;
	
	@Column(name = "fk_producto")
	private Producto fk_producto;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	
//	CONSTRUCTORS, SETTERS AND GETTERS//	CONSTRUCTORS, SETTERS AND GETTERS
	public ProductoDetalleOrden() {}


	public ProductoDetalleOrden(Integer fk_detalle_orden, Producto fk_producto, Integer cantidad) {
		super();
		this.fk_detalle_orden = fk_detalle_orden;
		this.fk_producto = fk_producto;
		this.cantidad = cantidad;
	}


	public Integer getFk_detalle_orden() {
		return fk_detalle_orden;
	}


	public void setFk_detalle_orden(Integer fk_detalle_orden) {
		this.fk_detalle_orden = fk_detalle_orden;
	}


	public Producto getFk_producto() {
		return fk_producto;
	}


	public void setFk_producto(Producto fk_producto) {
		this.fk_producto = fk_producto;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
