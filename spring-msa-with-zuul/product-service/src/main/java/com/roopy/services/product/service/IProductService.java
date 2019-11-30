package com.roopy.services.product.service;

import java.util.List;

import com.roopy.services.product.domain.Order;
import com.roopy.services.product.domain.OrderDetail;

public interface IProductService {
	public List<OrderDetail> save(Order order);
}

