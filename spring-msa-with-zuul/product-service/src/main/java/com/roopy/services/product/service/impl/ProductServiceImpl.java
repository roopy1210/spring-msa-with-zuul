package com.roopy.services.product.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roopy.services.product.domain.Order;
import com.roopy.services.product.domain.OrderDetail;
import com.roopy.services.product.domain.Product;
import com.roopy.services.product.repository.ProductRepository;
import com.roopy.services.product.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
	@Override
	public List<OrderDetail> save(Order order) {

		if (null != order.getOrderDetails() && order.getOrderDetails().size() > 0) {
			
			for (int i = 0; i < order.getOrderDetails().size(); i++) {
				/*기존상품정보조회*/
				Product product = productRepository.find(order.getOrderDetails().get(i).getProdCd());
				
				/*기존상품총수량정보업데이트*/
				product.setQty(product.getQty() - order.getOrderDetails().get(i).getQty());
				productRepository.save(product);
				
				order.getOrderDetails().get(i).setProduct(product);
			}
			
		}
		
		return order.getOrderDetails();
	}

}
