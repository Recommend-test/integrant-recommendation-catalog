package com.integrant.recommendation.product.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class ProductCategory.
 */
@Entity
@Table(name="PRODUCT_CATEGORY")
public class ProductCategory implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name="category_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	/** The category name. */
	@Column(name="category_name")
	private String categoryName;
	
	/** The products. */
	@OneToMany(mappedBy="category")
	private List<Product> products;

	/**
	 * Instantiates a new product category.
	 */
	public ProductCategory() {
	}

	/**
	 * Instantiates a new product category.
	 *
	 * @param id the id
	 */
	public ProductCategory(Integer id) {
		this.id = id;
	}

	/**
	 * Instantiates a new product category.
	 *
	 * @param categoryName the category name
	 */
	public ProductCategory(String categoryName) {
		this.categoryName = categoryName;
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
	 * Gets the category name.
	 *
	 * @return the category name
	 */
	public String getCategoryName() {
		return categoryName;
	}
	
	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", categoryName=" + categoryName + ", products=" + products + "]";
	}
}



