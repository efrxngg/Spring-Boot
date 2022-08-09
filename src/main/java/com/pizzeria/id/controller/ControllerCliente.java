package com.pizzeria.id.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzeria.id.interfaces.ICrudCabeceraOrden;
import com.pizzeria.id.interfaces.ICrudCliente;
import com.pizzeria.id.interfaces.ICrudDetalleOrden;
import com.pizzeria.id.interfaces.ICrudProducto;
import com.pizzeria.id.interfaces.ICrudProductoDetalleOrden;
import com.pizzeria.id.interfaces.ICrudTipoBasePizza;
import com.pizzeria.id.model.CabeceraOrden;
import com.pizzeria.id.model.Cliente;
import com.pizzeria.id.model.DetalleOrden;
import com.pizzeria.id.model.DetalleOrdenJs;
import com.pizzeria.id.model.IngredienteJs;
import com.pizzeria.id.model.OrdenJs;
import com.pizzeria.id.model.Producto;
import com.pizzeria.id.model.ProductoDetalleOrden;
import com.pizzeria.id.model.TipoBasePizza;

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
	@Autowired 
	private ICrudTipoBasePizza objCTBP;
	@Autowired 
	private ICrudProducto objCP;
	
	
	@GetMapping
	public ResponseEntity<List<CabeceraOrden>>getAllOrders(){
		return ResponseEntity.ok(objCCO.findAll());
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
		
//		Contenedor detalle orden
		DetalleOrden detalleOrdenOtros = null;
//		--- Recolector de costo de la pizza/s
		Double subTotal = 0.0;
		for(DetalleOrdenJs detalle: detallesDeLaOrden ) {
			System.out.println("Id Base Pizza: "+detalle.base_pizza);
			System.out.println("Cantidad: "+detalle.cantidad);
			System.out.println("Comentario: "+detalle.comentario);
//			--- Calculando el precio c/u pizza
			subTotal += getTipoBasePizza(detalle.base_pizza).getCosto() * detalle.cantidad;
			subTotal += detalle.otros;
			
			DetalleOrden detalleOrden = new DetalleOrden();
			detalleOrden.setFk_cabecera_orden(cbzOrdenGuardada.getId_cabecera_orden());
			detalleOrden.setFk_base_pizza(detalle.base_pizza);
			detalleOrden.setCantidad(detalle.cantidad);
			detalleOrden.setComentario(detalle.comentario);
			DetalleOrden detalleOrdenGuardada = objCDO.save(detalleOrden);
			
//			Actualizando otros
			DetalleOrden detOrd = updateDetalleDeLaOrden(detalleOrdenGuardada.getId_detalle_orden());
			detOrd.setOtros(detalle.otros);
			detalleOrdenOtros = objCDO.save(detOrd);
			
			System.out.println("4-. PROCESO ---------------------------");
			List<IngredienteJs>listaIngredientes = detalle.ingredientes;			
			for(IngredienteJs ingrediente: listaIngredientes) {
				System.out.println("Id Ingrediente: "+ingrediente.ingrediente+ " Cantidad: " + ingrediente.cantidad);
				
//				---Calculando el precio por ingrediente y cantidad
				subTotal += getProducto(ingrediente.ingrediente).getCosto() * ingrediente.cantidad;
				
				ProductoDetalleOrden pdo = new ProductoDetalleOrden();
				pdo.setFk_detalle_orden(detalleOrdenGuardada.getId_detalle_orden());
				pdo.setFk_producto(ingrediente.ingrediente);
				pdo.setCantidad(ingrediente.cantidad);
				
				objCPDO.save(pdo);
			}
		}
		
//		Actualizacion final al detalle de la orden
		DetalleOrden dos = updateDetalleDeLaOrden(detalleOrdenOtros.getId_detalle_orden());
		dos.setSub_total(subTotal);
		dos.setTotal(subTotal + (subTotal * 0.12));
		objCDO.save(dos);
	}
	
	
	private DetalleOrden updateDetalleDeLaOrden(Integer id) {
		Optional<DetalleOrden> optionalDO = objCDO.findById(id);
		if(optionalDO.isPresent()) {
			return optionalDO.get();
		}
		return null;
	}
	
	
	private TipoBasePizza getTipoBasePizza(Integer id) {
		Optional<TipoBasePizza> optionalTBP = objCTBP.findById(id);
		if(optionalTBP.isPresent()) {
			return optionalTBP.get();
		}
		return null;
	}
	
	
	private Producto getProducto(Integer id) {
		Optional<Producto> optionalProducto = objCP.findById(id);
		if(optionalProducto.isPresent()) {
			return optionalProducto.get();
		}
		return null;
	}
	
}
