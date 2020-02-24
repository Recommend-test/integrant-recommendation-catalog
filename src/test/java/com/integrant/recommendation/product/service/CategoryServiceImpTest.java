package com.integrant.recommendation.product.service;

import com.integrant.recommendation.product.model.ProductCategory;
import com.integrant.recommendation.product.repository.CategoryRepository;
import com.integrant.recommendation.product.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class CategoryServiceImpTest {

	public static final String CATEGORY_NAME = "Accessories%@$%@#$%#$%#@$%#@$%";

	@Mock
	private CategoryRepository categoryRepository;
//
//	@Mock
//	private ProductRepository productRepository;

	@InjectMocks
	private CategoryService categoryService;

	@BeforeEach
	void setUp() {
		ProductCategory productCategory = new ProductCategory(null, CATEGORY_NAME);
		when(categoryRepository.save(productCategory)).thenReturn(productCategory);
		when(categoryRepository.findById(1)).thenReturn(Optional.of(productCategory));
	}

	@Test
	void saveProductCategory() {
		ProductCategory productCategory = new ProductCategory(null, CATEGORY_NAME);
		Integer id = categoryService.saveProductCategory(productCategory);
		assertNotNull(id);
		assertEquals(Optional.of(1), id);
	}

	@Test
	void findAllProductCategories() {
	}

	@Test
	void findProductCategory() {
	}

	@Test
	void deleteProductCategory() {
	}

	@Test
	void updateProductCategory() {
	}

	@Test
	void findProductCategoryByOffsetAndLimit() {
	}

	@Test
	void validateProductCategoryDto() {
	}

	@Test
	void validateProductCategoryForUpdate() {
	}
}