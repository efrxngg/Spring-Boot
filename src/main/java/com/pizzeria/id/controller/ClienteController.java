package com.pizzeria.id.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzeria.id.interfaces.ICrudCliente;
import com.pizzeria.id.model.Cliente;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	@Autowired 
	private ICrudCliente objCC;
	
	@GetMapping("{id}")
	public Cliente getClientById(@PathVariable Integer id) {
		Optional<Cliente> optionalCliente = objCC.findById(id);
		return optionalCliente.get();
		}
}
