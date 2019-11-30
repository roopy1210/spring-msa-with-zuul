package com.roopy.services.product.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PaymentIdentity implements Serializable {

	private static final long serialVersionUID = 7061534858627725850L;
	
	@Column(name = "payment_id", nullable = false, length = 15)
	private String paymentId;
	
	@Column(name = "order_id", nullable = false, length = 15)
    private String orderId;

	@Column(name = "payment_seq", nullable = false)
    private int paymentSeq;

	public PaymentIdentity() {
	}

	public PaymentIdentity(String paymentId, String orderId, int paymentSeq) {
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.paymentSeq = paymentSeq;
	}

	/**
	 * @return the paymentId
	 */
	public String getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the paymentSeq
	 */
	public int getPaymentSeq() {
		return paymentSeq;
	}

	/**
	 * @param paymentSeq the paymentSeq to set
	 */
	public void setPaymentSeq(int paymentSeq) {
		this.paymentSeq = paymentSeq;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((paymentId == null) ? 0 : paymentId.hashCode());
		result = prime * result + paymentSeq;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentIdentity other = (PaymentIdentity) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (paymentId == null) {
			if (other.paymentId != null)
				return false;
		} else if (!paymentId.equals(other.paymentId))
			return false;
		if (paymentSeq != other.paymentSeq)
			return false;
		return true;
	}
}
