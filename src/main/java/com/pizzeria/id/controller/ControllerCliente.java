package com.pizzeria.id.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzeria.id.interfaces.ICrudCliente;
import com.pizzeria.id.model.Cliente;

@RestController
@RequestMapping("cliente")
public class ControllerCliente {
	@Autowired
	private ICrudCliente objCC;
	
	@GetMapping(value = "all")
	public ResponseEntity<List<Cliente>>getAllClients(){
		return ResponseEntity.ok(objCC.findAll());
	}
}
