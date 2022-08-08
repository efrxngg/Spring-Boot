package com.pizzeria.id.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter @Getter @Column(name = "id_producto")
	private Integer id_producto;
	
	@Setter @Getter @Column(name = "descripcion")
	private String descripcion;
	
	@Setter @Getter @Column(name = "costo")
	private Double costo;
	
	
	public Producto() {}


	public Producto(Integer id_producto, String descripcion, Double costo) {
		super();
		this.id_producto = id_producto;
		this.descripcion = descripcion;
		this.costo = costo;
	}
	
}
