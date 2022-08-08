package com.pizzeria.id.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pizzeria.id.interfaces.ICrudCabeceraOrden;
import com.pizzeria.id.model.CabeceraOrden;

@JsonSerialize
@RestController
@RequestMapping("/")
public class ControllerCabeceraOrden {
	
	private static final Logger LOG = LoggerFactory.getLogger(ControllerCabeceraOrden.class);
	
	@Autowired
	private ICrudCabeceraOrden objCCO;

	@GetMapping("all")
	public ResponseEntity<List<CabeceraOrden>> getAllOrders() {
		LOG.info("entra ");
		return ResponseEntity.ok(objCCO.findAll());
	}
}
