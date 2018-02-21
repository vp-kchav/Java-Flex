package com.vecteurplus.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "product", uniqueConstraints = {
		@UniqueConstraint(columnNames = "PRODUCT_ID"),
		@UniqueConstraint(columnNames = "PRODUCT_NAME"),
		@UniqueConstraint(columnNames = "PRODUCT_CODE")
})
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Category _category;
	private String _code;
	private float _cost;
	private String _description;
	private int _id;
	private String _name;
	private float _price;
	
	public Product() {	
	}
	
	public Product(String name, String code, float cost, float price,
			String desc, Category category) {
		_name = name;
		_code = code;
		_cost = cost;
		_price = price;
		_description = desc;
		_category = category;
	}

	public void setCategory(Category category) {
		_category = category;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	public Category getCategory() {
		return _category;
	}
	
	public void setCode(String code) {
		_code = code;
	}
	
	@Column(name = "PRODUCT_CODE", unique = true, nullable = false, length = 10)
	public String getCode() {
		return _code;
	}

	public void setCost(float cost) {
		_cost = cost;
	}

	@Column(name = "PRODUCT_COST", nullable = false, precision = 4)
	public float getCost() {
		return _cost;
	}

	public void setDescription(String description) {
		_description = description;
	}

	@Column(name = "PRODUCT_DESCRIPTION", nullable = false, length = 50)
	public String getDescription() {
		return _description;
	}
	
	public void setId(int id) {
		_id = id;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PRODUCT_ID", unique = true, nullable = false)
	public int getId() {
		return _id;
	}
		
	public void setName(String name) {
		_name = name;
	}
	
	@Column(name = "PRODUCT_NAME", unique = true, nullable = false, length = 30)
	public String getName() {
		return _name;
	}
	
	public void setPrice(float price) {
		_price = price;
	}

	@Column(name = "PRODUCT_PRICE", nullable = false, precision = 4)
	public float getPrice() {
		return _price;
	}

	@Override
	public String toString(){
		return "Product[id = " + getId() +", name = " + getName() + 
				", code = " + getCode() + ", cost = " + getCost() + 
				", price = " + getPrice() + ", code = " + getCategory().getCode() +
				", description = " + getDescription() + "]";
	}
	
}
