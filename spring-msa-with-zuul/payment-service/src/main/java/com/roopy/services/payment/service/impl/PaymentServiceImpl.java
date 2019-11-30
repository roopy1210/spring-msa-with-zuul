package com.roopy.services.payment.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roopy.services.payment.domain.Order;
import com.roopy.services.payment.domain.PaymentIdentity;
import com.roopy.services.payment.helper.IDGeneratorHelper;
import com.roopy.services.payment.repository.PaymentRepository;
import com.roopy.services.payment.service.IPaymentService;
import com.roopy.services.payment.util.DateUtil;

@Service
public class PaymentServiceImpl implements IPaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private IDGeneratorHelper idGenerator;

	@Transactional
	@Override
	public Order save(Order order) throws Exception {
		/*결제ID생성*/
		String paymentId = idGenerator.getPaymentId();
		
		int paymentSeq = 1;
		
		/*결제추가정보설정*/
		if (null != order.getPayments() && order.getPayments().size() > 0) {
			for (int i = 0; i < order.getPayments().size(); i++) {
				order.getPayments().get(i).setPaymentIdentity(new PaymentIdentity(paymentId, order.getOrderId(), paymentSeq + i));
				order.getPayments().get(i).setPaymentDtm(DateUtil.getCurrentDateTimeAsString());

				/*결제정보저장*/
				paymentRepository.savePayment(order.getPayments().get(i));
			}
		}
		
		return order;
	}

}
