package com.integrant.recommendation.product.service;

import java.util.List;

import com.integrant.recommendation.product.dto.CategoryDto;
import com.integrant.recommendation.product.exceptions.BadRequestException;
import com.integrant.recommendation.product.model.ProductCategory;
import com.integrant.recommendation.product.model.ProductCategoryPage;

/**
 * The Interface ProductService.
 */
public interface CategoryService {
	
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
	 * @param productCategory the product category
	 * @return the product category
	 */
	public ProductCategory updateProductCategory(ProductCategory productCategory);
	
	/**
	 * Find product category by offset and limit.
	 *
	 * @param offset the offset
	 * @param limit the limit
	 * @return the product category page
	 */
	public ProductCategoryPage findProductCategoryByOffsetAndLimit(Integer offset, Integer limit);
	
	/**
	 * Validate product category dto.
	 *
	 * @param productCategoryDto the product category dto
	 * @throws BadRequestException the bad request exception
	 */
	public void validateProductCategoryDto(CategoryDto productCategoryDto) throws BadRequestException;
	
	/**
	 * Validate product category.
	 *
	 * @param productCategory the product category
	 * @throws BadRequestException the bad request exception
	 */
	public void validateProductCategory(ProductCategory productCategory) throws BadRequestException;
}
