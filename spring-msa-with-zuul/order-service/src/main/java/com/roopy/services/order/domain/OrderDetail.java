package com.roopy.services.order.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_detail")
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = -178105276989733750L;
	
	@EmbeddedId
	private OrderDetailIdentity orderDetailIdentity;
	
	/*상품코드*/
	@Column(name = "prod_cd", nullable = false, length = 10)
	private String prodCd;
	
	/*수량*/
	@Column(name = "qty", nullable = false)
	private int qty;
	
	/*주문금액*/
	@Column(name = "order_amt", nullable = false)
	private int orderAmt;
	
	@OneToOne
	@JoinColumn(name = "prod_cd", insertable= false, updatable = false)
	private Product product;

	/**
	 * @return the orderDetailIdentity
	 */
	public OrderDetailIdentity getOrderDetailIdentity() {
		return orderDetailIdentity;
	}

	/**
	 * @param orderDetailIdentity the orderDetailIdentity to set
	 */
	public void setOrderDetailIdentity(OrderDetailIdentity orderDetailIdentity) {
		this.orderDetailIdentity = orderDetailIdentity;
	}

	/**
	 * @return the prodCd
	 */
	public String getProdCd() {
		return prodCd;
	}

	/**
	 * @param prodCd the prodCd to set
	 */
	public void setProdCd(String prodCd) {
		this.prodCd = prodCd;
	}

	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}

	/**
	 * @return the orderAmt
	 */
	public int getOrderAmt() {
		return orderAmt;
	}
	
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @param orderAmt the orderAmt to set
	 */
	public void setOrderAmt(int orderAmt) {
		this.orderAmt = orderAmt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderAmt;
		result = prime * result + ((orderDetailIdentity == null) ? 0 : orderDetailIdentity.hashCode());
		result = prime * result + ((prodCd == null) ? 0 : prodCd.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + qty;
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
		OrderDetail other = (OrderDetail) obj;
		if (orderAmt != other.orderAmt)
			return false;
		if (orderDetailIdentity == null) {
			if (other.orderDetailIdentity != null)
				return false;
		} else if (!orderDetailIdentity.equals(other.orderDetailIdentity))
			return false;
		if (prodCd == null) {
			if (other.prodCd != null)
				return false;
		} else if (!prodCd.equals(other.prodCd))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (qty != other.qty)
			return false;
		return true;
	}
}
