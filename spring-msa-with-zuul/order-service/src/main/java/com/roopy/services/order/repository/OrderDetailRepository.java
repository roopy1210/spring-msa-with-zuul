package com.roopy.services.order.repository;

import org.springframework.data.repository.Repository;

import com.roopy.services.order.domain.OrderDetail;
import com.roopy.services.order.domain.OrderDetailIdentity;

public interface OrderDetailRepository extends Repository<OrderDetail, OrderDetailIdentity>, OrderDetailRepositoryCustom {

}
