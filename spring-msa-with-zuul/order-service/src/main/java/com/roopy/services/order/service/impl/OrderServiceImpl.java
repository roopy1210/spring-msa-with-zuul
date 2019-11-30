package com.roopy.services.order.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roopy.services.order.domain.Order;
import com.roopy.services.order.domain.OrderDetailIdentity;
import com.roopy.services.order.repository.OrderDetailRepository;
import com.roopy.services.order.repository.OrderRepository;
import com.roopy.services.order.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Transactional
	@Override
	public Order save(Order order) throws Exception {
		
		int orderSeq = 1;
		
		/*주문상세추가정보설정*/
		for (int i = 0; i < order.getOrderDetails().size(); i++) {
			/*주문ID설정*/
			order.getOrderDetails().get(i).setOrderDetailIdentity(new OrderDetailIdentity(order.getOrderId(), orderSeq + i));
			
			/*주문상세정보 저장*/
			orderDetailRepository.save(order.getOrderDetails().get(i));
		}
		
		/*주문정보저장*/
		order = orderRepository.save(order);

		return order;
		
	}

	public Order find(String orderId) throws Exception {
		return orderRepository.find(orderId);
	}

	@Transactional
	@Override
	public Order updateOrderStatus(Order order) throws Exception {
		return orderRepository.save(order);
	}

}
