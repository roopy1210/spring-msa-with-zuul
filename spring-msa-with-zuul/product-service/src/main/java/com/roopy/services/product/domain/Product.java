package com.roopy.services.product.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product implements Serializable {

	private static final long serialVersionUID = 7876033846179941257L;
	
	/*상품코드*/
	@Id
	@Column(name = "prod_cd", nullable = false, length = 10)
	private String prodCd;
	
	/*상품명*/
	@Column(name = "prod_name", nullable = false, length = 100)
	private String prodName;
	
	/*상품금액*/
	@Column(name = "prod_amt", nullable = false)
	private Long prodAmt;
	
	/*세일여부*/
	@Column(name = "sale_yn", nullable = false, length = 1)
	private String saleYn;	
	
	/*수량*/
	@Column(name = "qty", nullable = false)
	private int qty;

	
	public Product() {
	}

	public Product(String prodCd, String prodName, Long prodAmt, String saleYn, int qty) {
		super();
		this.prodCd = prodCd;
		this.prodName = prodName;
		this.prodAmt = prodAmt;
		this.saleYn = saleYn;
		this.qty = qty;
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
	 * @return the prodName
	 */
	public String getProdName() {
		return prodName;
	}

	/**
	 * @param prodName the prodName to set
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	/**
	 * @return the prodAmt
	 */
	public Long getProdAmt() {
		return prodAmt;
	}

	/**
	 * @param prodAmt the prodAmt to set
	 */
	public void setProdAmt(Long prodAmt) {
		this.prodAmt = prodAmt;
	}

	/**
	 * @return the saleYn
	 */
	public String getSaleYn() {
		return saleYn;
	}

	/**
	 * @param saleYn the saleYn to set
	 */
	public void setSaleYn(String saleYn) {
		this.saleYn = saleYn;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prodAmt == null) ? 0 : prodAmt.hashCode());
		result = prime * result + ((prodCd == null) ? 0 : prodCd.hashCode());
		result = prime * result + ((prodName == null) ? 0 : prodName.hashCode());
		result = prime * result + qty;
		result = prime * result + ((saleYn == null) ? 0 : saleYn.hashCode());
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
		Product other = (Product) obj;
		if (prodAmt == null) {
			if (other.prodAmt != null)
				return false;
		} else if (!prodAmt.equals(other.prodAmt))
			return false;
		if (prodCd == null) {
			if (other.prodCd != null)
				return false;
		} else if (!prodCd.equals(other.prodCd))
			return false;
		if (prodName == null) {
			if (other.prodName != null)
				return false;
		} else if (!prodName.equals(other.prodName))
			return false;
		if (qty != other.qty)
			return false;
		if (saleYn == null) {
			if (other.saleYn != null)
				return false;
		} else if (!saleYn.equals(other.saleYn))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [prodCd=" + prodCd + ", prodName=" + prodName + ", prodAmt=" + prodAmt + ", saleYn=" + saleYn
				+ ", qty=" + qty + "]";
	}

}
