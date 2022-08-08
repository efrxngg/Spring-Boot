package com.pizzeria.id.model;

import javax.persistence.*;


@Entity
@Table(name = "orden")
public class Orden {
	@Id
	@Column(name = "id_orden")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_orden;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "fk_cliente")
	private Cliente fk_cliente;
	
	public Orden() {}
	

	public Integer getId_orden() {
		return id_orden;
	}

	public void setId_orden(Integer id_orden) {
		this.id_orden = id_orden;
	}

	public Cliente getFk_cliente() {
		return fk_cliente;
	}

	public void setFk_cliente(Cliente fk_cliente) {
		this.fk_cliente = fk_cliente;
	}

	
}
