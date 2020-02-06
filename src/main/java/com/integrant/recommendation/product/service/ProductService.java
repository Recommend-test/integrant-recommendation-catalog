package com.integrant.recommendation.product.service;

import java.util.List;

import com.integrant.recommendation.product.model.ProductCategory;

/**
 * The Interface ProductService.
 */
public interface ProductService {
	
	/**
	 * Find all product categories.
	 *
	 * @return the list
	 */
	public List<ProductCategory> findAllProductCategories();

	/**
	 * Save product category.
	 *
	 * @param productCatalog the product catalog
	 * @return the string
	 */
	public Integer saveProductCategory(ProductCategory productCatalog);
	
	/**
	 * Find product category.
	 *
	 * @param productCategoryId the product category id
	 * @return the product category
	 */
	public ProductCategory findProductCategory(Integer productCategoryId);
	
	/**
	 * Delete product category.
	 *
	 * @param productCategoryId the product category id
	 * @return the product category
	 */
	public void deleteProductCategory(Integer productCategoryId);
	
	/**
	 * Update product category.
	 *
	 * @param productCategoryId the product category id
	 * @return the product category
	 */
	public ProductCategory updateProductCategory(ProductCategory productCategory);
}
