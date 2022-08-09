package com.pizzeria.id.model;

import java.util.List;

public class DetalleOrdenJs{
	public Integer base_pizza;
	public Integer cantidad;
	public String comentario;
	public List<IngredienteJs> ingredientes;
	
	@Override
	public String toString() {
		return "DetalleOrdenJs [base_pizza=" + base_pizza + ", cantidad=" + cantidad + ", comentario=" + comentario
				+ ", ingredientes=" + ingredientes + "]";
	}
	
	
}