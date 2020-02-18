package com.integrant.recommendation.product.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.integrant.recommendation.product.model.Product;
import com.integrant.recommendation.product.model.ProductCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class ProductDto.
 */
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
	 * Builds the.
	 *
	 * @return the product
	 */
	public Product build(Integer categoryId) {
		return new Product(name, description, new ProductCategory(categoryId));
	}
}
