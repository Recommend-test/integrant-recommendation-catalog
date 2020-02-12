package com.integrant.recommendation.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrant.recommendation.product.model.Product;

/**
 * The Interface ProductRepository.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	/**
	 * Find product by product name.
	 *
	 * @param name the name
	 * @return the product
	 */
	public Product findProductByProductName(String name);
	
	/**
	 * Find all products by category id.
	 *
	 * @param categoryId the category id
	 * @param pageable the pageable
	 * @return the page
	 */
	public Page<Product> findAllProductsByCategoryId(Integer categoryId, Pageable pageable);
}
