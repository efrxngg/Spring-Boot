package com.pizzeria.id.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzeria.id.model.CabeceraOrden;

public interface ICrudCabeceraOrden extends JpaRepository<CabeceraOrden, Integer> {

}
