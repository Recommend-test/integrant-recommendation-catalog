package com.integrant.recommendation.product.service;

import java.util.List;

import com.integrant.recommendation.product.dto.ProductDto;
import com.integrant.recommendation.product.exceptions.BadRequestException;
import com.integrant.recommendation.product.exceptions.ResourceNotFoundException;
import com.integrant.recommendation.product.model.Product;
import com.integrant.recommendation.product.model.ProductPage;

/**
 * The Interface ProductService.
 */
public interface ProductService {
	
	/**
	 * Find all products.
	 *
	 * @return the list
	 */
	public List<Product> findAllProducts();

	/**
	 * Save product.
	 *
	 * @param product the product
	 * @return the integer
	 */
	public Integer saveProduct(Product product);
	
	/**
	 * Find product.
	 *
	 * @param productId the product id
	 * @return the product
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public Product findProduct(Integer productId) throws ResourceNotFoundException;
	
	/**
	 * Delete product.
	 *
	 * @param productId the product id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public void deleteProduct(Integer productId) throws ResourceNotFoundException;
	
	/**
	 * Update product.
	 *
	 * @param product the product
	 * @return the product
	 */
	public Product updateProduct(Product product);
	
	/**
	 * Find products by offset and limit.
	 *
	 * @param offset the offset
	 * @param limit the limit
	 * @return the product page
	 */
	public ProductPage findProductsByOffsetAndLimit(Integer offset, Integer limit);
	
	/**
	 * Find products by category offset and limit.
	 *
	 * @param categoryId the category id
	 * @param offset the offset
	 * @param limit the limit
	 * @return the product page
	 */
	public ProductPage findProductsByCategoryOffsetAndLimit(Integer categoryId, Integer offset, Integer limit);
	
	/**
	 * Validate product dto.
	 *
	 * @param productDto the product dto
	 * @throws BadRequestException the bad request exception
	 */
	public void validateProductDto(ProductDto productDto) throws BadRequestException;
	
	/**
	 * Validate product.
	 *
	 * @param product the product
	 * @throws BadRequestException the bad request exception
	 */
	public void validateProduct(Product product) throws BadRequestException;

}
