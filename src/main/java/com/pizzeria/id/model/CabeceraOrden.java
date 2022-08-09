package com.pizzeria.id.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cabecera_orden")
public class CabeceraOrden implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cabecera_orden")
	private Integer id_cabecera_orden;

	@Column(name = "fk_cliente")
	private Integer fk_cliente;

	@Column(name = "estado")
	private Boolean estado;
	
	@Column(name = "fecha_pedido")
	private Date fecha_pedido;
	
	@Column(name = "fecha_entrega")
	private Date fecha_entrega;

	
//	Setters and getters and Constructors
	public CabeceraOrden() {}

	
	public CabeceraOrden(Integer id_cabecera_orden, Integer fk_cliente, Boolean estado, Date fecha_pedido,
			Date fecha_entrega) {
		super();
		this.id_cabecera_orden = id_cabecera_orden;
		this.fk_cliente = fk_cliente;
		this.estado = estado;
		this.fecha_pedido = fecha_pedido;
		this.fecha_entrega = fecha_entrega;

	}


	public Integer getId_cabecera_orden() {
		return id_cabecera_orden;
	}


	public void setId_cabecera_orden(Integer id_cabecera_orden) {
		this.id_cabecera_orden = id_cabecera_orden;
	}


	public Integer getFk_cliente() {
		return fk_cliente;
	}


	public void setFk_cliente(Integer fk_cliente) {
		this.fk_cliente = fk_cliente;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public Date getFecha_pedido() {
		return fecha_pedido;
	}


	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}


	public Date getFecha_entrega() {
		return fecha_entrega;
	}


	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}
	

	
}
