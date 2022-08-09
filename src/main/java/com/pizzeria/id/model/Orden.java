package com.pizzeria.id.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Orden {
	@Id
	private int id;
	
	private String nombre;
	
	private String contacto;
	
	@OneToMany(mappedBy = "orden")
	private List<DetalleOrdenJS> ordenes;

	public Orden() {}

	
	@Override
	public String toString() {
		return "Orden [id=" + id + ", nombre=" + nombre + ", contacto=" + contacto + ", ordenes=" + ordenes + "]";
	}


	public Orden(String nombre, String contacto, List<DetalleOrdenJS> ordenes) {
		super();
		this.nombre = nombre;
		this.contacto = contacto;
		this.ordenes = ordenes;
	}



	public void setOrdenes(List<DetalleOrdenJS> ordenes) {
		this.ordenes = ordenes;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
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


	public List<DetalleOrdenJS> getOrdenes() {
		return ordenes;
	}

	
	
}


@Entity
class DetalleOrdenJS{
	@Id
	private int id;
	private Integer base_pizza;
	private Integer cantidad;
	private String comentario;
	@ManyToOne
	private Orden orden;
	
	@ManyToMany
	private Set<ProductoJS> producto;
	
	public int getId() {
		return id;
	}
	
	public DetalleOrdenJS() {}
	
	
	public DetalleOrdenJS(Integer base_pizza, Integer cantidad, String comentario) {
		super();
		this.base_pizza = base_pizza;
		this.cantidad = cantidad;
		this.comentario = comentario;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Integer getBase_pizza() {
		return base_pizza;
	}
	public void setBase_pizza(Integer base_pizza) {
		this.base_pizza = base_pizza;
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
	
	
}


