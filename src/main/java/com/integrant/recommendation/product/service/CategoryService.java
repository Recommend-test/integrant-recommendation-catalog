package com.integrant.recommendation.product.service;

import java.util.List;

import com.integrant.recommendation.product.dto.CategoryDto;
import com.integrant.recommendation.product.exceptions.BadRequestException;
import com.integrant.recommendation.product.exceptions.DataConflictException;
import com.integrant.recommendation.product.exceptions.ResourceNotFoundException;
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
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public ProductCategory findProductCategory(Integer productCategoryId) throws ResourceNotFoundException;
	
	/**
	 * Delete product category.
	 *
	 * @param productCategoryId the product category id
	 * @throws DataConflictException the data conflict exception
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public void deleteProductCategory(Integer productCategoryId) throws DataConflictException, ResourceNotFoundException;
	
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
	 * Validate product category for update.
	 *
	 * @param productCategoryDto the product category dto
	 * @throws BadRequestException the bad request exception
	 */
	public void validateProductCategoryForUpdate(CategoryDto productCategoryDto) throws BadRequestException;
}
