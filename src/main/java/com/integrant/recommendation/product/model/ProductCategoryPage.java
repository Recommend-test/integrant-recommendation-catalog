package com.integrant.recommendation.product.model;

import java.io.Serializable;
import java.util.List;

/**
 * The Class ProductCategoryPage.
 */
public class ProductCategoryPage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The product category list. */
	private List<ProductCategory> productCategoryList;
	
	/** The total count. */
	private Long totalCount;

	/**
	 * Instantiates a new product category page.
	 *
	 * @param productCategoryList the product category list
	 * @param totalCount the total count
	 */
	public ProductCategoryPage(List<ProductCategory> productCategoryList, Long totalCount) {
		this.productCategoryList = productCategoryList;
		this.totalCount = totalCount;
	}

	/**
	 * Gets the product category list.
	 *
	 * @return the product category list
	 */
	public List<ProductCategory> getProductCategoryList() {
		return productCategoryList;
	}

	/**
	 * Gets the total count.
	 *
	 * @return the total count
	 */
	public Long getTotalCount() {
		return totalCount;
	}
}
