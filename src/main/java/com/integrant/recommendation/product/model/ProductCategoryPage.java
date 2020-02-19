package com.integrant.recommendation.product.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class ProductCategoryPage.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductCategoryPage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The product category list. */
	private List<ProductCategory> productCategoryList;
	
	/** The total count. */
	private Long totalCount;
}
