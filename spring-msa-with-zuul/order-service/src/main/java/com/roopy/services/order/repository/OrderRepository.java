package com.roopy.services.order.repository;

import org.springframework.data.repository.Repository;

import com.roopy.services.order.domain.Order;

public interface OrderRepository extends Repository<Order, String>, OrderRepositoryCustom {

}
