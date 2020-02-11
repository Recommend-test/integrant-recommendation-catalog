package com.integrant.recommendation.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrant.recommendation.product.model.ProductCategory;

/**
 * The Interface ProductCategoryRepository.
 */
@Repository
public interface CategoryRepository extends JpaRepository<ProductCategory, Integer>{

	/**
	 * Find product category by category name.
	 *
	 * @param categoryName the category name
	 * @return the product category
	 */
	public ProductCategory findProductCategoryByCategoryName(String categoryName);
}
