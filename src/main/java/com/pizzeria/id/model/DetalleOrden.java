package com.pizzeria.id.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "detalle_orden")
public class DetalleOrden implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle_orden")
	private Integer id_detalle_orden;
	
	@Column(name = "fk_cabecera_orden")
	private Integer fk_cabecera_orden;
	
	@Column(name = "fk_base_pizza")
	private Integer fk_base_pizza;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "comentario")
	private String comentario;
	
	@Column(name = "sub_total")
	private Double sub_total;
	
	@Column(name = "otros")
	private Double otros;
	
	@Column(name ="total")
	private Double total;
	
	
//	CONSTRUCTORS, SETTERS AND GETTERS
	public DetalleOrden() {}

	public DetalleOrden(Integer id_detalle_orden, Integer fk_cabecera_orden, Integer fk_base_pizza, Integer cantidad,
			String comentario, Double sub_total, Double otros, Double total) {
		super();
		this.id_detalle_orden = id_detalle_orden;
		this.fk_cabecera_orden = fk_cabecera_orden;
		this.fk_base_pizza = fk_base_pizza;
		this.cantidad = cantidad;
		this.comentario = comentario;
		this.sub_total = sub_total;
		this.otros = otros;
		this.total = total;
	}

	public Integer getId_detalle_orden() {
		return id_detalle_orden;
	}

	public void setId_detalle_orden(Integer id_detalle_orden) {
		this.id_detalle_orden = id_detalle_orden;
	}

	public Integer getFk_cabecera_orden() {
		return fk_cabecera_orden;
	}

	public void setFk_cabecera_orden(Integer fk_cabecera_orden) {
		this.fk_cabecera_orden = fk_cabecera_orden;
	}

	public Integer getFk_base_pizza() {
		return fk_base_pizza;
	}

	public void setFk_base_pizza(Integer fk_base_pizza) {
		this.fk_base_pizza = fk_base_pizza;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Double getSub_total() {
		return sub_total;
	}

	public void setSub_total(Double sub_total) {
		this.sub_total = sub_total;
	}

	public Double getOtros() {
		return otros;
	}

	public void setOtros(Double otros) {
		this.otros = otros;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
		
}
