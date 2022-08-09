package com.pizzeria.id.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class ProductoJS {
	@Id
	private int id;
	
	private String descripcion;
	
	private Double costo;
	
	@ManyToMany
	private Set<DetalleOrdenJS> orden;
}
