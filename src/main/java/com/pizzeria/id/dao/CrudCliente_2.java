package com.pizzeria.id.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.pizzeria.id.interfaces.ICrudCliente_2;
import com.pizzeria.id.model.Cliente;

@Repository
@Transactional
public class CrudCliente_2 implements ICrudCliente_2{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Cliente> getAllClientes() {
		return entityManager.createQuery("FROM Cliente").getResultList();
	}

}
