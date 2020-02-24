package com.integrant.recommendation.product.repository;

import com.integrant.recommendation.product.model.Product;
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
public class ProductRepositoryTest {

	private static final String PRODUCT_NAME = "IPhone%^#$%$#%@#$!@#$!@#$";
	private static final String CATEGORY_NAME = "Accessories@!#$!@#$!@#$#$%";

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	public void testFindProduct() {
		ProductCategory productCategory = new ProductCategory(null, CATEGORY_NAME, null);
		categoryRepository.save(productCategory);
		Product product = new Product(PRODUCT_NAME, PRODUCT_NAME, productCategory);
		productRepository.save(product);
		Product iphone = productRepository.findProductByProductName(PRODUCT_NAME);
		assertNotNull(iphone);
		assertEquals(PRODUCT_NAME, iphone.getProductName());
	}

	@After
	public  void clear(){
		productRepository.delete(productRepository.findProductByProductName(PRODUCT_NAME));
		categoryRepository.delete(categoryRepository.findProductCategoryByCategoryName(CATEGORY_NAME));
	}

}