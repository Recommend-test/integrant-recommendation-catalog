package com.integrant.recommendation.product.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.integrant.recommendation.product.model.ProductCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * The Class ProductCategoryDto.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDto implements Serializable {	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	private Integer id;

	/** The category name. */
	@NotNull(message = "Category Name must not be null")
	@NotEmpty(message = "Category Name must not be empty")
	private String categoryName;

	/**
	 * Builds the.
	 *
	 * @return the product category
	 */
	public ProductCategory build() {
		return new ProductCategory(categoryName);
	}
	
	/**
	 * Builds the for update.
	 *
	 * @return the product category
	 */
	public ProductCategory buildForUpdate() {
		return new ProductCategory(id, categoryName);
	}
}

