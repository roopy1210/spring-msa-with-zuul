package com.roopy.services.order.service;

import com.roopy.services.order.domain.Order;

public interface IOrderService {
	
	public Order save(Order order) throws Exception;
	
	public Order find(String orderId) throws Exception;
	
	public Order updateOrderStatus(Order order) throws Exception;
	
}
