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
import com.integrant.recommendation.product.dto.CategoryDto;
import com.integrant.recommendation.product.exceptions.BadRequestException;
import com.integrant.recommendation.product.exceptions.DataConflictException;
import com.integrant.recommendation.product.exceptions.ResourceNotFoundException;
import com.integrant.recommendation.product.model.Product;
import com.integrant.recommendation.product.model.ProductCategory;
import com.integrant.recommendation.product.model.ProductCategoryPage;
import com.integrant.recommendation.product.repository.CategoryRepository;
import com.integrant.recommendation.product.repository.ProductRepository;

/**
 * The Class ProductService.
 */
@Service
public class CategoryServiceImp implements CategoryService{

	/** The product category repository. */
	@Autowired
	private CategoryRepository productCategoryRepository;

	@Autowired
	private ProductRepository productRepository;

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());


	/**
	 * Save product category.
	 *
	 * @param productCategory the product category
	 * @return the integer
	 */
	@Override
	public Integer saveProductCategory(ProductCategory productCategory) {

		productCategoryRepository.save(productCategory);

		return productCategory.getId();
	}


	/**
	 * Find all product categories.
	 *
	 * @return the list
	 */
	@Override
	public List<ProductCategory> findAllProductCategories() {
		return productCategoryRepository.findAll();
	}


	/**
	 * Find product category.
	 *
	 * @param productCategoryId the product category id
	 * @return the product category
	 */
	@Override
	public ProductCategory findProductCategory(Integer productCategoryId) throws ResourceNotFoundException{

		ProductCategory productCategory = productCategoryRepository.findById(productCategoryId).orElse(null);
		
		if(productCategory == null)
			throw new ResourceNotFoundException(AppConstants.CATEGORY_NOT_EXISTS);

		return productCategory;
	}

	/**
	 * Delete product category.
	 *
	 * @param productCategoryId the product category id
	 * @throws DataConflictException the data conflict exception
	 * @throws ResourceNotFoundException 
	 */
	@Override
	public void deleteProductCategory(Integer productCategoryId) throws DataConflictException, ResourceNotFoundException {

		ProductCategory productCategory = productCategoryRepository.findById(productCategoryId).orElse(null);
		
		if(productCategory == null)
			throw new ResourceNotFoundException(AppConstants.CATEGORY_NOT_EXISTS);
		
		List<Product> products = productRepository.findAllProductsByCategoryId(productCategoryId);

		if(!products.isEmpty())
			throw new DataConflictException(AppConstants.CATEGORY_HAS_RELATED_PRODUCTS);

		productCategoryRepository.deleteById(productCategoryId);
	}

	/**
	 * Update product category.
	 *
	 * @param productCategory the product category
	 * @return the product category
	 */
	@Override
	public ProductCategory updateProductCategory(ProductCategory productCategory) {

		return productCategoryRepository.save(productCategory);

	}

	/**
	 * Find product category by offset and limit.
	 *
	 * @param offset the offset
	 * @param limit the limit
	 * @return the product category page
	 */
	@Override
	public ProductCategoryPage findProductCategoryByOffsetAndLimit(Integer offset, Integer limit) {

		Page<ProductCategory> page = productCategoryRepository.findAll(PageRequest.of(offset, limit, Sort.by("id")));

		return new ProductCategoryPage(page.getContent(), page.getTotalElements());
	}

	/**
	 * Validate product category dto.
	 *
	 * @param productCategoryDto the product category dto
	 * @throws BadRequestException the bad request exception
	 */
	@Override
	public void validateProductCategoryDto(CategoryDto productCategoryDto) throws BadRequestException {

		ProductCategory productCategory = productCategoryRepository.findProductCategoryByCategoryName(productCategoryDto.getCategoryName());

		if(productCategory != null) {

			logger.info(AppConstants.CATEGORY_ALREADY_EXISTS);

			throw new BadRequestException(AppConstants.CATEGORY_ALREADY_EXISTS);
		}
	}


	/**
	 * Validate product category.
	 *
	 * @param productCategory the product category
	 * @throws BadRequestException the bad request exception
	 */
	public void validateProductCategory(ProductCategory productCategory) throws BadRequestException {

		ProductCategory currentProductCategory = productCategoryRepository.findById(productCategory.getId()).orElse(null);

		if(currentProductCategory == null) {

			logger.info(AppConstants.CATEGORY_NOT_EXISTS);

			throw new BadRequestException(AppConstants.CATEGORY_NOT_EXISTS);
		}
	}
}
