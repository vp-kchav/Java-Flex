package com.vecteurplus.inventory.model;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "category", uniqueConstraints = {
		@UniqueConstraint(columnNames = "CATEGORY_ID"),
		@UniqueConstraint(columnNames = "CATEGORY_NAME"),
		@UniqueConstraint(columnNames = "CATEGORY_CODE")
})

public class Category implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String _code;
	private int _id;
	private String _name;
	
	public Category() {
	}
		
	public Category(String name, String code) {
		_name = name;
		_code = code;
	}

	public void setCode(String code) {
		_code = code;
	}
	
	@Column(name = "CATEGORY_CODE", unique = true, nullable = false, length = 10)
	public String getCode() {
		return _code;
	}
	
	public void setId(int id) {
		_id = id;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	public int getId() {
		return _id;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	@Column(name = "CATEGORY_NAME", unique = true, nullable = false, length = 30)
	public String getName() {
		return _name;
	}
	
	@Override
	public String toString(){
		return "Category[id = " + getId() + ", name = " +
				getName() + ", code = " + getCode() + "]";
	}
	
}
