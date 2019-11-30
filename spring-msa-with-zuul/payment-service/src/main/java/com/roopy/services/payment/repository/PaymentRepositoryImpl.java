package com.roopy.services.payment.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.roopy.services.payment.domain.Payment;

public class PaymentRepositoryImpl implements PaymentRepositoryCustom {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Payment savePayment(Payment payment) {
		return em.merge(payment);
	}

}
