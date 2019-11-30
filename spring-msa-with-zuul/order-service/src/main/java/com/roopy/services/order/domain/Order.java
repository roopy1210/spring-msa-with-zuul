package com.roopy.services.order.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orderm")
public class Order implements Serializable {

	private static final long serialVersionUID = -58749526895126954L;
	
	/*주문ID*/
	@Id
	@Column(name = "order_id", nullable = false, length = 15)
	private String orderId;
	
	/*주문자ID*/
	@Column(name = "orderer_id", nullable = false, length = 15)
	private String ordererId;
	
	/*주문일시*/
	@Column(name = "order_dtm", nullable = false, length = 14)
	private String orderDtm;
	
	/*주문금액*/
	@Column(name = "total_order_amt", nullable = false, length = 20)
	private Long totalOrderAmt;
	
	/*주문사태*/
	@Column(name = "order_status", nullable = false, length = 1)
	private String orderStatus;
	
	@OneToMany
	@JoinColumn(name = "order_id", updatable = false)
	private List<OrderDetail> orderDetails;
	
	@OneToMany
	@JoinColumn(name = "order_id", updatable = false)
	private List<Payment> payments;

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
	 * @return the ordererId
	 */
	public String getOrdererId() {
		return ordererId;
	}

	/**
	 * @param ordererId the ordererId to set
	 */
	public void setOrdererId(String ordererId) {
		this.ordererId = ordererId;
	}

	/**
	 * @return the orderDtm
	 */
	public String getOrderDtm() {
		return orderDtm;
	}

	/**
	 * @param orderDtm the orderDtm to set
	 */
	public void setOrderDtm(String orderDtm) {
		this.orderDtm = orderDtm;
	}

	/**
	 * @return the totalOrderAmt
	 */
	public Long getTotalOrderAmt() {
		return totalOrderAmt;
	}

	/**
	 * @param totalOrderAmt the totalOrderAmt to set
	 */
	public void setTotalOrderAmt(Long totalOrderAmt) {
		this.totalOrderAmt = totalOrderAmt;
	}
	
	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the orderDetails
	 */
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	/**
	 * @param orderDetails the orderDetails to set
	 */
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	/**
	 * @return the payments
	 */
	public List<Payment> getPayments() {
		return payments;
	}

	/**
	 * @param payments the payments to set
	 */
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderDetails == null) ? 0 : orderDetails.hashCode());
		result = prime * result + ((orderDtm == null) ? 0 : orderDtm.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((ordererId == null) ? 0 : ordererId.hashCode());
		result = prime * result + ((payments == null) ? 0 : payments.hashCode());
		result = prime * result + ((totalOrderAmt == null) ? 0 : totalOrderAmt.hashCode());
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
		Order other = (Order) obj;
		if (orderDetails == null) {
			if (other.orderDetails != null)
				return false;
		} else if (!orderDetails.equals(other.orderDetails))
			return false;
		if (orderDtm == null) {
			if (other.orderDtm != null)
				return false;
		} else if (!orderDtm.equals(other.orderDtm))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (ordererId == null) {
			if (other.ordererId != null)
				return false;
		} else if (!ordererId.equals(other.ordererId))
			return false;
		if (payments == null) {
			if (other.payments != null)
				return false;
		} else if (!payments.equals(other.payments))
			return false;
		if (totalOrderAmt == null) {
			if (other.totalOrderAmt != null)
				return false;
		} else if (!totalOrderAmt.equals(other.totalOrderAmt))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", ordererId=" + ordererId + ", orderDtm=" + orderDtm + ", totalOrderAmt="
				+ totalOrderAmt + ", orderDetails=" + orderDetails + ", payments=" + payments + ", toString()="
				+ super.toString() + "]";
	}
	
}
