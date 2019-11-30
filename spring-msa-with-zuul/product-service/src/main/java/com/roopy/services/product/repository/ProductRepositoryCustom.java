package com.roopy.services.product.repository;

import com.roopy.services.product.domain.Product;

public interface ProductRepositoryCustom {
	
	public Product save(Product product);
	
	public Product find(String prodCd);
	
}
