package com.roopy.services.payment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment implements Serializable {

	private static final long serialVersionUID = 3633796565061773501L;
	
	@EmbeddedId
	private PaymentIdentity paymentIdentity;
	
	/*결제방법*/
	@Column(name = "payment_method", nullable = false, length = 2)
	private String paymentMethod;
	
	/*결제금액*/
	@Column(name = "payment_amt", nullable = false)
	private Long paymentAmt;
	
	/*결제일자*/
	@Column(name = "payment_dtm", nullable = false, length = 14)
	private String paymentDtm;
	
	/*결제자*/
	@Column(name = "biller", nullable = false, length = 15)
	private String biller;

	/**
	 * @return the paymentIdentity
	 */
	public PaymentIdentity getPaymentIdentity() {
		return paymentIdentity;
	}

	/**
	 * @param paymentIdentity the paymentIdentity to set
	 */
	public void setPaymentIdentity(PaymentIdentity paymentIdentity) {
		this.paymentIdentity = paymentIdentity;
	}

	/**
	 * @return the paymentMethod
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * @return the paymentAmt
	 */
	public Long getPaymentAmt() {
		return paymentAmt;
	}

	/**
	 * @param paymentAmt the paymentAmt to set
	 */
	public void setPaymentAmt(Long paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	/**
	 * @return the paymentDtm
	 */
	public String getPaymentDtm() {
		return paymentDtm;
	}

	/**
	 * @param paymentDtm the paymentDtm to set
	 */
	public void setPaymentDtm(String paymentDtm) {
		this.paymentDtm = paymentDtm;
	}

	/**
	 * @return the biller
	 */
	public String getBiller() {
		return biller;
	}

	/**
	 * @param biller the biller to set
	 */
	public void setBiller(String biller) {
		this.biller = biller;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((biller == null) ? 0 : biller.hashCode());
		result = prime * result + ((paymentAmt == null) ? 0 : paymentAmt.hashCode());
		result = prime * result + ((paymentDtm == null) ? 0 : paymentDtm.hashCode());
		result = prime * result + ((paymentIdentity == null) ? 0 : paymentIdentity.hashCode());
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
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
		Payment other = (Payment) obj;
		if (biller == null) {
			if (other.biller != null)
				return false;
		} else if (!biller.equals(other.biller))
			return false;
		if (paymentAmt == null) {
			if (other.paymentAmt != null)
				return false;
		} else if (!paymentAmt.equals(other.paymentAmt))
			return false;
		if (paymentDtm == null) {
			if (other.paymentDtm != null)
				return false;
		} else if (!paymentDtm.equals(other.paymentDtm))
			return false;
		if (paymentIdentity == null) {
			if (other.paymentIdentity != null)
				return false;
		} else if (!paymentIdentity.equals(other.paymentIdentity))
			return false;
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Payment [paymentIdentity=" + paymentIdentity + ", paymentMethod=" + paymentMethod + ", paymentAmt="
				+ paymentAmt + ", paymentDtm=" + paymentDtm + ", biller=" + biller + ", toString()=" + super.toString()
				+ "]";
	}
}
