package com.pizzeria.id.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzeria.id.interfaces.ICrudCabeceraOrden;
import com.pizzeria.id.interfaces.ICrudCliente;
import com.pizzeria.id.interfaces.ICrudDetalleOrden;
import com.pizzeria.id.interfaces.ICrudProductoDetalleOrden;
import com.pizzeria.id.model.CabeceraOrden;
import com.pizzeria.id.model.Cliente;
import com.pizzeria.id.model.DetalleOrden;
import com.pizzeria.id.model.DetalleOrdenJs;
import com.pizzeria.id.model.IngredienteJs;
import com.pizzeria.id.model.OrdenJs;
import com.pizzeria.id.model.ProductoDetalleOrden;

@RestController
@RequestMapping("orden")
public class ControllerCliente {

	@Autowired
	private ICrudCliente objCC;
	@Autowired
	private ICrudCabeceraOrden objCCO;
	@Autowired
	private ICrudDetalleOrden objCDO;
	@Autowired
	private ICrudProductoDetalleOrden objCPDO;
	
	
	@PostMapping("add")
	public Integer insertCliente(@RequestBody Cliente cliente) {
//		1.- Creacion del cliente : nombre contacto
		Cliente clienteGuardado = objCC.save(cliente);
		
//		2.- Creacion de la orden: id cliente
		CabeceraOrden cbzOrden = new CabeceraOrden();
		cbzOrden.setFk_cliente(clienteGuardado.getId());
		CabeceraOrden cbzOrdenGuardada = objCCO.save(cbzOrden);
		
//		3.- Seleccion del tipo pizza mas comentarios:  id cabecera, base pizza, cantidad, comentario
		DetalleOrden detalleOrden = new DetalleOrden();
		detalleOrden.setFk_cabecera_orden(cbzOrdenGuardada.getId_cabecera_orden());
		detalleOrden.setFk_base_pizza(null);
		detalleOrden.setCantidad(null);
		detalleOrden.setComentario(null);
		DetalleOrden detalleOrdenGuardada = objCDO.save(detalleOrden);
		
//		4.- Asignacion de ingredientes a la orden: detalle orden, ingrediente o producto, cantidad
		ProductoDetalleOrden pdo = new ProductoDetalleOrden();
		pdo.setFk_detalle_orden(detalleOrdenGuardada.getId_detalle_orden());
		pdo.setFk_producto(null);
		pdo.setCantidad(null);
		
		objCPDO.save(pdo);
		return null;
	}
	
	
	@PostMapping("prueba")
	public void prueba(@RequestBody OrdenJs orden) {
		System.out.println("Datos del cliente: "+orden.nombre +" "+ orden.contacto);
		
		List<DetalleOrdenJs> detallesDeLaOrden = orden.detallesDeLaOrden;
		for(DetalleOrdenJs detalle: detallesDeLaOrden ) {
			System.out.println("Id Base Pizza: "+detalle.base_pizza);
			System.out.println("Cantidad: "+detalle.cantidad);
			System.out.println("Comentario: "+detalle.comentario);
			List<IngredienteJs>listaIngredientes = detalle.ingredientes;
			for(IngredienteJs ingrediente: listaIngredientes) {
				System.out.println("Id Ingrediente: "+ingrediente.ingrediente+ " Cantidad: " + ingrediente.cantidad);
			}
		}
		
		
	}
	
	
	@PostMapping("insertar-orden")
	public void insertOrden(@RequestBody OrdenJs orden) {
		System.out.println("1-. PROCESO ---------------------------");
		System.out.println("Datos del cliente: "+orden.nombre +" "+ orden.contacto);
		
		Cliente cliente = new Cliente();
		cliente.setNombre(orden.nombre);
		cliente.setContacto(orden.contacto);
		Cliente clienteGuardado = objCC.save(cliente);
		
		System.out.println("2-. PROCESO ---------------------------");
		CabeceraOrden cbzOrden = new CabeceraOrden();
		cbzOrden.setFk_cliente(clienteGuardado.getId());
		CabeceraOrden cbzOrdenGuardada = objCCO.save(cbzOrden);
		
		System.out.println("3-. PROCESO ---------------------------");
		List<DetalleOrdenJs> detallesDeLaOrden = orden.detallesDeLaOrden;
		for(DetalleOrdenJs detalle: detallesDeLaOrden ) {
			System.out.println("Id Base Pizza: "+detalle.base_pizza);
			System.out.println("Cantidad: "+detalle.cantidad);
			System.out.println("Comentario: "+detalle.comentario);
			
			DetalleOrden detalleOrden = new DetalleOrden();
			detalleOrden.setFk_cabecera_orden(cbzOrdenGuardada.getId_cabecera_orden());
			detalleOrden.setFk_base_pizza(detalle.base_pizza);
			detalleOrden.setCantidad(detalle.cantidad);
			detalleOrden.setComentario(detalle.comentario);
			DetalleOrden detalleOrdenGuardada = objCDO.save(detalleOrden);
			
			System.out.println("4-. PROCESO ---------------------------");
			List<IngredienteJs>listaIngredientes = detalle.ingredientes;			
			for(IngredienteJs ingrediente: listaIngredientes) {
				System.out.println("Id Ingrediente: "+ingrediente.ingrediente+ " Cantidad: " + ingrediente.cantidad);
				
				ProductoDetalleOrden pdo = new ProductoDetalleOrden();
				pdo.setFk_detalle_orden(detalleOrdenGuardada.getId_detalle_orden());
				pdo.setFk_producto(ingrediente.ingrediente);
				pdo.setCantidad(ingrediente.cantidad);
				
				objCPDO.save(pdo);
			}
		}
		
	}
	
}
