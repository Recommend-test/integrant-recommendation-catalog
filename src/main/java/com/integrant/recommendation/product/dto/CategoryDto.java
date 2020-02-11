package com.integrant.recommendation.product.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.integrant.recommendation.product.model.ProductCategory;


/**
 * The Class ProductCategoryDto.
 */
public class CategoryDto implements Serializable {	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The category name. */
	@NotNull(message = "Category Name must not be null")
	@NotEmpty(message = "Category Name must not be empty")
	private String categoryName;

	/**
	 * Instantiates a new product category dto.
	 */
	public CategoryDto() {
	}

	/**
	 * Instantiates a new product category dto.
	 *
	 * @param categoryName the category name
	 */
	public CategoryDto(String categoryName) {
		this.categoryName = categoryName;
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
	 * Builds the.
	 *
	 * @return the product category
	 */
	public ProductCategory build() {
		return new ProductCategory(categoryName);
	}
}

