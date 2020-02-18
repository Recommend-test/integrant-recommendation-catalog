package com.integrant.recommendation.product.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.integrant.recommendation.product.constants.AppConstants;
import com.integrant.recommendation.product.dto.ProductDto;
import com.integrant.recommendation.product.exceptions.BadRequestException;
import com.integrant.recommendation.product.exceptions.ResourceNotFoundException;
import com.integrant.recommendation.product.model.Product;
import com.integrant.recommendation.product.model.ProductPage;
import com.integrant.recommendation.product.repository.ProductRepository;

/**
 * The Class ProductServiceImp.
 */
@Service
public class ProductServiceImp implements ProductService {

	/** The product repository. */
	@Autowired
	private ProductRepository productRepository;

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());


	/**
	 * Save product.
	 *
	 * @param product the product
	 * @return the integer
	 */
	@Override
	public Integer saveProduct(Product product) {

		productRepository.save(product);

		return product.getId();
	}

	/**
	 * Find all products.
	 *
	 * @return the list
	 */
	@Override
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	/**
	 * Find product.
	 *
	 * @param productId the product id
	 * @return the product
	 * @throws ResourceNotFoundException 
	 */
	@Override
	public Product findProduct(Integer productId) throws ResourceNotFoundException {

		Product product = productRepository.findById(productId).orElse(null);

		if(product == null)
			throw new ResourceNotFoundException(AppConstants.PRODUCT_NOT_EXISTS);

		return product;
	}

	/**
	 * Delete product.
	 *
	 * @param productId the product id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	public void deleteProduct(Integer productId) throws ResourceNotFoundException {

		Product product = productRepository.findById(productId).orElse(null);

		if(product == null)
			throw new ResourceNotFoundException(AppConstants.PRODUCT_NOT_EXISTS);
		
		productRepository.deleteById(productId);
	}

	/**
	 * Update product.
	 *
	 * @param product the product
	 * @return the product
	 */
	@Override
	public Product updateProduct(Product product) {

		return productRepository.save(product);

	}

	/**
	 * Find products by offset and limit.
	 *
	 * @param offset the offset
	 * @param limit the limit
	 * @return the product page
	 */
	@Override
	public ProductPage findProductsByOffsetAndLimit(Integer offset, Integer limit) {

		Page<Product> page = productRepository.findAll(PageRequest.of(offset, limit, Sort.by("id")));

		return new ProductPage(page.getContent(), page.getTotalElements());
	}

	/**
	 * Find products by category offset and limit.
	 *
	 * @param categoryId the category id
	 * @param offset the offset
	 * @param limit the limit
	 * @return the product page
	 */
	@Override
	public ProductPage findProductsByCategoryOffsetAndLimit(Integer categoryId, Integer offset, Integer limit) {

		Page<Product> page = productRepository.findAllProductsByCategoryId(categoryId, PageRequest.of(offset, limit));

		return new ProductPage(page.getContent(), page.getTotalElements());
	}

	/**
	 * Validate product dto.
	 *
	 * @param productDto the product dto
	 * @throws BadRequestException the bad request exception
	 */
	@Override
	public void validateProductDto(ProductDto productDto) throws BadRequestException {

		Product product = productRepository.findProductByProductName(productDto.getName());

		if(product != null) {

			logger.info(AppConstants.PRODUCT_ALREADY_EXISTS);

			throw new BadRequestException(AppConstants.PRODUCT_ALREADY_EXISTS);
		}
	}
	/**
	 * Validate product.
	 *
	 * @param product the product
	 * @throws BadRequestException the bad request exception
	 */
	public void validateProduct(Product product) throws BadRequestException {

		Product currentProduct = productRepository.findById(product.getId()).orElse(null);

		if(currentProduct == null)
			throw new BadRequestException(AppConstants.PRODUCT_NOT_EXISTS);

	}


}
