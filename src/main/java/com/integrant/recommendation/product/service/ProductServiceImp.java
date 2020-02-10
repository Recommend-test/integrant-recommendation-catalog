package com.integrant.recommendation.product.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrant.recommendation.product.model.ProductCategory;
import com.integrant.recommendation.product.repository.ProductCategoryRepository;

/**
 * The Class ProductService.
 */
@Service
public class ProductServiceImp implements ProductService{
	
	/** The product catalog repository. */
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
    /** The logger. */
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Save product catalog.
	 *
	 * @param productCatalogDto the product catalog dto
	 */
    @Override
	public Integer saveProductCategory(ProductCategory productCategory) {
		
    	productCategoryRepository.save(productCategory);
		
		return productCategory.getId();
	}
	
	/**
	 * Find all product catalogs.
	 *
	 * @return the list
	 */
    @Override
	public List<ProductCategory> findAllProductCategories() {
		return productCategoryRepository.findAll();
	}
	
	/**
	 * Find product catalogs.
	 *
	 * @param productCatalogId the product catalog id
	 * @return the product catalog
	 */
    @Override
	public ProductCategory findProductCategory(Integer productCategoryId) {
    	
    	return productCategoryRepository.findById(productCategoryId).orElse(null);
	}

	@Override
	public void deleteProductCategory(Integer productCategoryId) {
		
		productCategoryRepository.deleteById(productCategoryId);
	}

	@Override
	public ProductCategory updateProductCategory(ProductCategory productCategory) {
		
		return productCategoryRepository.save(productCategory);

	}

}
