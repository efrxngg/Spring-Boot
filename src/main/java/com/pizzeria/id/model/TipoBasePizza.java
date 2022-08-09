package com.pizzeria.id.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="tipo_base_pizza")
public class TipoBasePizza implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_base_pizza")
	private Integer id_base_pizza;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "costo")
	private Double costo;
	
	
//	CONSTRUCTORS, SETTERS AND GETTERS
	public TipoBasePizza() {}


	public TipoBasePizza(Integer id_base_pizza, String descripcion, Double costo) {
		super();
		this.id_base_pizza = id_base_pizza;
		this.descripcion = descripcion;
		this.costo = costo;
	}


	public Integer getId_base_pizza() {
		return id_base_pizza;
	}


	public void setId_base_pizza(Integer id_base_pizza) {
		this.id_base_pizza = id_base_pizza;
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
