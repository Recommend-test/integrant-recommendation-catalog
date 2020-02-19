package com.integrant.recommendation.product.constants;

/**
 * The Class AppConstants.
 */
public final class AppConstants {
	
	  /**
  	 * Instantiates a new app constants.
  	 */
  	private AppConstants() {
	    throw new IllegalStateException("AppConstants class");
	  }

	/** The Constant PRODUCT_NOT_EXISTS. */
	public static final String PRODUCT_NOT_EXISTS = "This product not exists";
	
	/** The Constant PRODUCT_ALREADY_EXISTS. */
	public static final String PRODUCT_ALREADY_EXISTS = "This product already exists";
	
	/** The Constant CATEGORY_NOT_EXISTS. */
	public static final String CATEGORY_NOT_EXISTS = "This category not exists";
	
	/** The Constant CATEGORY_ALREADY_EXISTS. */
	public static final String CATEGORY_ALREADY_EXISTS = "This category already exists";

	/** The Constant CATEGORY_HAS_RELATED_PRODUCTS. */
	public static final String CATEGORY_HAS_RELATED_PRODUCTS = "This Category has related products";

	/** The Constant INVALID_CATEGORY_ID. */
	public static final String INVALID_CATEGORY_ID = "Invalid category id";

	public static final String INVALID_PRODUCT_ID = "Invalid product id";

}
