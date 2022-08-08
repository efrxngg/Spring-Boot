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
@Table(name ="tipo_base_pizza")
public class TipoBasePizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter @Getter @Column(name = "id_base_pizza")
	private Integer id_base_pizza;
	
	@Setter @Getter @Column(name = "descripcion")
	private String descripcion;
	
	@Setter @Getter @Column(name = "costo")
	private Double costo;
	
	
	public TipoBasePizza() {}


	public TipoBasePizza(Integer id_base_pizza, String descripcion, Double costo) {
		super();
		this.id_base_pizza = id_base_pizza;
		this.descripcion = descripcion;
		this.costo = costo;
	}
	
}
