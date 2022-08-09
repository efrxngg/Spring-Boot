package com.pizzeria.id.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Integer id_producto;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "costo")
	private Double costo;
	
	
//	CONSTRUCTORS, SETTERS AND GETTERS
	public Producto() {}


	public Producto(Integer id_producto, String descripcion, Double costo) {
		super();
		this.id_producto = id_producto;
		this.descripcion = descripcion;
		this.costo = costo;
	}


	public Integer getId_producto() {
		return id_producto;
	}


	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Double getCosto() {
		return costo;
	}


	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
}
