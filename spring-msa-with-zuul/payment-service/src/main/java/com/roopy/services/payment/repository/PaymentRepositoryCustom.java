package com.roopy.services.payment.repository;

import com.roopy.services.payment.domain.Payment;

public interface PaymentRepositoryCustom {
	
	public Payment savePayment(Payment payment);
	
}
