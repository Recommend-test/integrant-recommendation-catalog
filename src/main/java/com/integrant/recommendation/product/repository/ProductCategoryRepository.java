package com.integrant.recommendation.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrant.recommendation.product.model.ProductCategory;

/**
 * The Interface ProductCategoryRepository.
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{
}
