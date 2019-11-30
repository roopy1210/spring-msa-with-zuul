package com.roopy.services.product.repository;

import org.springframework.data.repository.Repository;

import com.roopy.services.product.domain.Product;

public interface ProductRepository extends Repository<Product, String>, ProductRepositoryCustom {

}
