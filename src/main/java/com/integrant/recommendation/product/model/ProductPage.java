package com.integrant.recommendation.product.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ProductPage.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductPage implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The product list. */
	private List<Product> productList;
	
	/** The total count. */
	private Long totalCount;
}
