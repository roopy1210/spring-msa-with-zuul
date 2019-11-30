package com.roopy.services.payment.repository;

import org.springframework.data.repository.Repository;

import com.roopy.services.payment.domain.Payment;
import com.roopy.services.payment.domain.PaymentIdentity;

public interface PaymentRepository extends Repository<Payment, PaymentIdentity>, PaymentRepositoryCustom {

}
