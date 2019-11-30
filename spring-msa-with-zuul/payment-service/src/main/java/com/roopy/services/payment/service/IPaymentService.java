package com.roopy.services.payment.service;

import com.roopy.services.payment.domain.Order;

public interface IPaymentService {
	
	public Order save(Order order) throws Exception;
	
}
