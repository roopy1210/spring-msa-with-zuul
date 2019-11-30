package com.roopy.services.order.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.roopy.services.order.domain.Order;

public class OrderRepositoryImpl implements OrderRepositoryCustom {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Order save(Order order) {
		return em.merge(order);
	}

	@Override
	public Order find(String orderId) {
		Order order = null; 
		
		order = em.find(Order.class, orderId);
		
		return order;
	}

}
