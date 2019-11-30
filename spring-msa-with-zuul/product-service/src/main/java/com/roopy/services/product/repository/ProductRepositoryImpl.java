package com.roopy.services.product.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.roopy.services.product.domain.Product;

public class ProductRepositoryImpl implements ProductRepositoryCustom {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Product save(Product product) {
		return em.merge(product);
	}

	@Override
	public Product find(String prodCd) {
		return em.find(Product.class, prodCd);
	}

}
