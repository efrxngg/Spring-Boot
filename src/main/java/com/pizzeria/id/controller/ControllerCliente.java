package com.pizzeria.id.controller;
//
//
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//
import com.pizzeria.id.interfaces.ICrudCliente;
import com.pizzeria.id.interfaces.ICrudOrden;
import com.pizzeria.id.model.Cliente;
import com.pizzeria.id.model.Orden;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import java.util.Optional;
//
@RestController
@RequestMapping("cliente")
public class ControllerCliente {
	@Autowired
	private ICrudCliente objCC;
	
	@Autowired
	private ICrudOrden objCO;
	
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAllClients(){
		
		List<Cliente> listaClientes = objCC.findAll();
		
		return ResponseEntity.ok(listaClientes);
	}
	
}


//	@GetMapping
//	@RequestMapping(value = "{id_cliente}", method = RequestMethod.GET)
//	public ResponseEntity<Cliente> getOneClientById(@PathVariable("id_cliente") Integer id_cliente){
//		Optional<Cliente> optionalClient = objCC.findById(id_cliente);
//		if(optionalClient.isPresent()) {
//			return ResponseEntity.ok(optionalClient.get());
//		}
//		else {			
//			return ResponseEntity.noContent().build();
//		}
//	}
//	
//	
//	@PostMapping
//	public ResponseEntity<Cliente>createClient(@RequestBody Cliente clienteBody){
//		Cliente newC = objCC.save(clienteBody);
//		
//		return ResponseEntity.ok(newC);
//	}
//	
//	
//	@PutMapping()
//	public ResponseEntity<Cliente>updateClientById(@RequestBody Cliente clienteBody){
//		Optional<Cliente>optionalClient = objCC.findById(clienteBody.getId());
//		
//		if(optionalClient.isPresent()) {
//			Cliente updateClient = optionalClient.get();
//			updateClient.setNombre(clienteBody.getNombre());
//			updateClient.setCedula(clienteBody.getCedula());
//			updateClient.setTelefono(clienteBody.getTelefono());
//			objCC.save(updateClient);
//			return ResponseEntity.ok(updateClient);
//		}
//		else {			
//			return ResponseEntity.notFound().build();
//			
//		}
//		
//	}
//	
//	
//	@DeleteMapping(value = "{id_cliente}")
//	public ResponseEntity<Void>deleteClientById( @PathVariable("id_cliente") Integer id_cliente){
//		objCC.deleteById(id_cliente);
//		return ResponseEntity.ok(null);
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
