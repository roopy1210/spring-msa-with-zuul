package com.roopy.services.delivery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {
	
	private static Logger log = LoggerFactory.getLogger(DeliveryController.class);
	
	@RequestMapping(value = "/delivery/{invoiceNo}", method = RequestMethod.POST)
	public void findDeliveryByInoviceNo(HttpServletRequest request, HttpServletResponse response, @PathVariable String invoiceNo) throws Exception {
		log.info("[{}] 배송조회", invoiceNo);
	}
}
