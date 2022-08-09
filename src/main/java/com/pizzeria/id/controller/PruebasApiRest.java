package com.pizzeria.id.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzeria.id.interfaces.ICrudOrden;
import com.pizzeria.id.model.Orden;

@RestController
@RequestMapping("test")
public class PruebasApiRest {
	
	@Autowired 
	private ICrudOrden objCO;
	
	@PostMapping
	public ResponseEntity<Orden>addOrder(@RequestBody Orden orden){
		System.out.print(orden.toString());
		return ResponseEntity.ok(null);
	}
		
	
	
}
