package com.pizzeria.id.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@Column(name = "id_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name = "nombre")
	private String nombre;
	
	
	@Column(name = "contacto")
	private String contacto;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "fk_cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Orden> ordenes;
	
	
	public void agregarOrdenes(Orden orden) {
		if(ordenes == null) ordenes = new ArrayList<Orden>();
		ordenes.add(orden);
		orden.setFk_cliente(this);
	}
	
	public Cliente() {}

	public Cliente( String nombre, String contacto) {
		this.nombre = nombre;
		this.contacto = contacto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public List<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List ordenes) {
		this.ordenes = ordenes;
	}
	
}
