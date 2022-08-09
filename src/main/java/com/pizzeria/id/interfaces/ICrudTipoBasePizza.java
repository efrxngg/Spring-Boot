package com.pizzeria.id.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzeria.id.model.TipoBasePizza;

public interface ICrudTipoBasePizza extends JpaRepository<TipoBasePizza, Integer>{

}
