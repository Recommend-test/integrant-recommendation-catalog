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
	
	/** The category. */
	@ManyToOne
	@JoinColumn(name="category_id", nullable=false)
	@JsonIgnore
	private ProductCategory category;


	/**
	 * Instantiates a new product.
	 *
	 * @param productName the product name
	 * @param productDescription the product description
	 * @param category the category
	 */
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


	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName() {
		return productName;
	}


	/**
	 * Sets the product name.
	 *
	 * @param productName the new product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}


	/**
	 * Gets the product description.
	 *
	 * @return the product description
	 */
	public String getProductDescription() {
		return productDescription;
	}


	/**
	 * Sets the product description.
	 *
	 * @param productDescription the new product description
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public ProductCategory getCategory() {
		return category;
	}


	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
}

