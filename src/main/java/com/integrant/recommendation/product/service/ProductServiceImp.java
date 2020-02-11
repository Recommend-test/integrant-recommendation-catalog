package com.integrant.recommendation.product.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.integrant.recommendation.product.model.ProductCategory;
import com.integrant.recommendation.product.repository.ProductCategoryRepository;

/**
 * The Class ProductService.
 */
@Service
public class ProductServiceImp implements ProductService{
	
	/** The product category repository. */
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
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
	public ProductCategory findProductCategory(Integer productCategoryId) {
    	
    	return productCategoryRepository.findById(productCategoryId).orElse(null);
	}

	/**
	 * Delete product category.
	 *
	 * @param productCategoryId the product category id
	 */
	@Override
	public void deleteProductCategory(Integer productCategoryId) {
		
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
	 * @return the list
	 */
	@Override
	public List<ProductCategory> findProductCategoryByOffsetAndLimit(Integer offset, Integer limit) {
		
		return productCategoryRepository.findAll(PageRequest.of(offset, limit)).getContent();
	}

}
