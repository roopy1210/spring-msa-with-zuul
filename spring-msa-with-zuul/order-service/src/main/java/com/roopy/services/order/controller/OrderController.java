package com.roopy.services.order.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.roopy.services.order.domain.Order;
import com.roopy.services.order.helper.IDGeneratorHelper;
import com.roopy.services.order.service.IOrderService;

@RestController
public class OrderController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IDGeneratorHelper idGenerator;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public Order save(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Order order) throws Exception {
		
		/*주문ID생성*/
		String orderId = idGenerator.getOrderId();
		
		/*주문ID설정*/
		order.setOrderId(orderId);
		
		/*주문날짜설정*/
		order.setOrderDtm(orderId.substring(1));
		
		/*결제처리*/	
		HttpEntity<Order> ordRequest = new HttpEntity<>(order);
		ResponseEntity<List> pymentResponse =  restTemplate.postForEntity("http://payment-service/payment", ordRequest, List.class);
		
		/*상품수량업데이트처리*/
		ResponseEntity<List> productResponse = null;
		if (pymentResponse.getStatusCodeValue() == 200) {
			productResponse =  restTemplate.postForEntity("http://product-service/products", ordRequest, List.class);
		}
		
		/*주문정보저장*/
		if (pymentResponse.getStatusCodeValue() == 200 && productResponse.getStatusCodeValue() == 200) {
			/*결제처리와 상품정보 업데이트가 정상적으로 처리 된 경우 주문상태를 완료로 변경한다.*/
			order.setOrderStatus("C");
			order = orderService.save(order);
			order.setPayments(pymentResponse.getBody());
		}
		
		return order;
	}
	
	@RequestMapping(value = "/order/{orderId}", method = RequestMethod.POST)
	public Order findOrder(HttpServletRequest request, HttpServletResponse response, @PathVariable String orderId,
			@RequestParam HashMap<String, String> param) throws Exception {
		
		return orderService.find(orderId);
	}
	
	
}
