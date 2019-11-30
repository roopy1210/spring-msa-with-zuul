package com.roopy.services.order.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.roopy.services.order.domain.OrderDetail;

public class OrderDetailRepositoryImpl implements OrderDetailRepositoryCustom {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public OrderDetail save(OrderDetail orderDetail) {
		return em.merge(orderDetail);
	}

}
