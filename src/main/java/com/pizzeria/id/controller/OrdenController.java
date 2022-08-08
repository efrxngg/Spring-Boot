package com.pizzeria.id.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzeria.id.interfaces.ICrudCliente;
import com.pizzeria.id.interfaces.ICrudOrden;
import com.pizzeria.id.model.Cliente;
import com.pizzeria.id.model.Orden;



@RestController
@RequestMapping("orden")
public class OrdenController {
	
	@Autowired
	private ICrudOrden objCO;
	
	@Autowired
	private ICrudCliente objCC;
	
	
	@GetMapping("setOrden")
	public ResponseEntity<Orden>setOrden(){
		Cliente cliente = new Cliente("Gisell", "0997188087");
		Cliente clienteGuardado = objCC.save(cliente);
		
		Orden orden = new Orden();
		orden.setFk_cliente(clienteGuardado);
		objCO.save(orden);
		return ResponseEntity.ok(orden);
	}
	
	@GetMapping
	public ResponseEntity<List<Orden>>getAllOrdens(){
		List<Orden> ordenes = objCO.findAll();
		return ResponseEntity.ok(ordenes);
	}
	
}
