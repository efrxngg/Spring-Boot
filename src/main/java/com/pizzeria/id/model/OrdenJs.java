package com.pizzeria.id.model;

import java.util.List;

public class OrdenJs {
	public String nombre;
	public String contacto;
	public List<DetalleOrdenJs> detallesDeLaOrden;
	
	
	@Override
	public String toString() {
		return "OrdenJs [nombre=" + nombre + ", contacto=" + contacto + ", detallesDeLaOrden=" + detallesDeLaOrden
				+ "]";
	}
	
	
}



