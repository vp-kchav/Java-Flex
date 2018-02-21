package com.vecteurplus.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="stock", uniqueConstraints= {
		@UniqueConstraint(columnNames = "STOCK_ID"),
		@UniqueConstraint(columnNames = "STOCK_CODE")
})

public class Stock implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String _code;
	private int _id;
	private Product _product;
	private int _quantity;
	
	public Stock() {
	}
	
	public Stock(int quantity, Product product) {
		_quantity = quantity;
		_product = product;
	}
	
	public void setCode(String code) {
		_code = code;
	}
	
	@Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
	public String getCode() {
		return _code;
	}

	public void setId(int id) {
		_id = id;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	public int getId() {
		return _id;
	}

	public void setProduct(Product product) {
		_product = product;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	public Product getProduct() {
		return _product;
	}
	
	public void setQuantity(int qty) {
		_quantity = qty;
	}
	
	@Column(name = "STOCK_QUANTITY", nullable = false)
	public int getQuantity() {
		return _quantity;
	}
	
	@Override
	public String toString(){
		return "Stock[id = " + getId() + ", code = " + getCode() +
				", pro_code = " + getProduct().getCode() + ", quantity = " + getQuantity() + "]";
	}
	
}
