package com.integrant.recommendation.product.model;

import java.io.Serializable;
import java.util.List;

/**
 * The Class ProductPage.
 */
public class ProductPage implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The product list. */
	private List<Product> productList;
	
	/** The total count. */
	private Long totalCount;

	/**
	 * Instantiates a new product page.
	 *
	 * @param productList the product list
	 * @param totalCount the total count
	 */
	public ProductPage(List<Product> productList, Long totalCount) {
		this.productList = productList;
		this.totalCount = totalCount;
	}

	/**
	 * Gets the product list.
	 *
	 * @return the product list
	 */
	public List<Product> getProductList() {
		return productList;
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
