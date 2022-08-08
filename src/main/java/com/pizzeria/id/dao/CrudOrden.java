//package com.pizzeria.id.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Repository;
//
//import com.pizzeria.id.interfaces.ICrudOrden;
//import com.pizzeria.id.model.Orden;
//
//@Repository
//@Transactional
//public class CrudOrden implements ICrudOrden{
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	@Override
//	public List<Orden> getAllOrdenes(){
//		return entityManager.createQuery("FROM Orden").getResultList();
//	}
//	
//}
