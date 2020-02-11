package com.integrant.recommendation.product.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.integrant.recommendation.product.model.Product;
import com.integrant.recommendation.product.model.ProductCategory;

/**
 * The Class ProductDto.
 */
public class ProductDto  implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The product name. */
	@NotNull(message = "Product Name must not be null")
	@NotEmpty(message = "Product Name must not be empty")
	private String name;

	/** The product description. */
	@NotNull(message = "Product description must not be null")
	@NotEmpty(message = "Product description must not be empty")
	private String description;

	/** The product category id. */
	@NotNull(message = "Product Category Id must not be null")
	private Integer categoryId;

	/**
	 * Instantiates a new product dto.
	 */
	public ProductDto() {
	}

	/**
	 * Instantiates a new product dto.
	 *
	 * @param name the name
	 * @param description the description
	 * @param categoryId the category id
	 */
	public ProductDto(String name, String description, Integer categoryId) {
		this.name = name;
		this.description = description;
		this.categoryId = categoryId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets the category id.
	 *
	 * @return the category id
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * Builds the.
	 *
	 * @return the product
	 */
	public Product build(Integer categoryId) {
		return new Product(name, description, new ProductCategory(categoryId));
	}
}
