package com.integrant.recommendation.product.service;

import java.util.List;

import com.integrant.recommendation.product.dto.ProductDto;
import com.integrant.recommendation.product.exceptions.BadRequestException;
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
	 */
	public Product findProduct(Integer productId);
	
	/**
	 * Delete product.
	 *
	 * @param productId the product id
	 */
	public void deleteProduct(Integer productId);
	
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
