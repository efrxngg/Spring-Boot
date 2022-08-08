package com.pizzeria.id.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzeria.id.interfaces.ICrudCliente_2;
import com.pizzeria.id.model.Cliente;

@RestController
@RequestMapping("cliente_2")
public class ClienteController{
	@Autowired
	private ICrudCliente_2 objCC2;
	
	@GetMapping
	public List<Cliente>getAllClientes(){
		return objCC2.getAllClientes();
	}
	
}
