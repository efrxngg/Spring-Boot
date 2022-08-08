package com.pizzeria.id.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "detalle_orden")
public class DetalleOrden implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter @Getter @Column(name = "id_detalle_orden")
	private Integer id_detalle_orden;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name  = "fk_cabecera_orden")
	private CabeceraOrden fk_cabecera_orden;
	
	
	public DetalleOrden(){}


	public Integer getId_detalle_orden() {
		return id_detalle_orden;
	}


	public void setId_detalle_orden(Integer id_detalle_orden) {
		this.id_detalle_orden = id_detalle_orden;
	}


	public CabeceraOrden getFk_cabecera_orden() {
		return fk_cabecera_orden;
	}


	public void setFk_cabecera_orden(CabeceraOrden fk_cabecera_orden) {
		this.fk_cabecera_orden = fk_cabecera_orden;
	}
	
	
	
}
