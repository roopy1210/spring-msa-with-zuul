package com.roopy.services.order.repository;

import com.roopy.services.order.domain.Order;

public interface OrderRepositoryCustom {
	
	/*
	 * 주문정보저장
	 */
	public Order save(Order order); 

	/*
	 * 주문정보조회
	 */
	public Order find(String orderId); 
}
