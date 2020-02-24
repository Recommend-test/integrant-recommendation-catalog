package com.integrant.recommendation.product.repository;

import com.integrant.recommendation.product.model.ProductCategory;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootTestApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CategoryRepositoryTest {

	private static final String CATEGORY_NAME = "Accessories!#$!@#$!@#$@#!$";

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	public void testFindProductCategory() {
		ProductCategory productCategory = new ProductCategory(null, CATEGORY_NAME, null);
		categoryRepository.save(productCategory);
		ProductCategory accessories = categoryRepository.findProductCategoryByCategoryName(CATEGORY_NAME);
		assertNotNull(accessories);
		assertEquals(CATEGORY_NAME, accessories.getCategoryName());
	}

	@After
	public  void clear(){
		categoryRepository.delete(categoryRepository.findProductCategoryByCategoryName(CATEGORY_NAME));
	}

}