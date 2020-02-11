package com.integrant.recommendation.product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class Product.
 */
@Entity
@Table(name="PRODUCT")
public class Product implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	/** The product name. */
	@Column(name="product_name")
	private String productName;

	/** The product description. */
	@Column(name="description")
	private String productDescription;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	@JsonIgnore
	private ProductCategory category;


	public Product(String productName, String productDescription, ProductCategory category) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.category = category;
	}


	/**
	 * Instantiates a new product.
	 */
	public Product() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public ProductCategory getCategory() {
		return category;
	}


	public void setCategory(ProductCategory category) {
		this.category = category;
	}
}

