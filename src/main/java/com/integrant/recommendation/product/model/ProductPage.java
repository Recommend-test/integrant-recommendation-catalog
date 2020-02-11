package com.integrant.recommendation.product.model;

import java.io.Serializable;
import java.util.List;

public class ProductPage implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private List<Product> productList;
	
	private Long totalCount;

	public ProductPage(List<Product> productList, Long totalCount) {
		this.productList = productList;
		this.totalCount = totalCount;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public Long getTotalCount() {
		return totalCount;
	}
}
