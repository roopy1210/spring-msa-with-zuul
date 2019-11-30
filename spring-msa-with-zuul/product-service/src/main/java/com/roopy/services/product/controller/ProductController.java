package com.roopy.services.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.roopy.services.product.domain.Order;
import com.roopy.services.product.service.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public void save(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Order order) throws Exception {
		
		/*상품수량업데이트*/
		productService.save(order);
	}
}
