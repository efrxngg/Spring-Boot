package com.pizzeria.id.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "fk_detalle_orden")
	private Integer fk_detalle_orden;
	
	@Column(name = "fk_producto")
	private Integer fk_producto;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	
//	CONSTRUCTORS, SETTERS AND GETTERS//	CONSTRUCTORS, SETTERS AND GETTERS
	public ProductoDetalleOrden() {}


	public ProductoDetalleOrden(Integer id, Integer fk_detalle_orden, Integer fk_producto, Integer cantidad) {
		super();
		this.id = id;
		this.fk_detalle_orden = fk_detalle_orden;
		this.fk_producto = fk_producto;
		this.cantidad = cantidad;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getFk_detalle_orden() {
		return fk_detalle_orden;
	}


	public void setFk_detalle_orden(Integer fk_detalle_orden) {
		this.fk_detalle_orden = fk_detalle_orden;
	}


	public Integer getFk_producto() {
		return fk_producto;
	}


	public void setFk_producto(Integer fk_producto) {
		this.fk_producto = fk_producto;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
