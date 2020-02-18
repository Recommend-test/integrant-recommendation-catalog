package com.integrant.recommendation.product.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.integrant.recommendation.product.dto.ProductDto;
import com.integrant.recommendation.product.exceptions.BadRequestException;
import com.integrant.recommendation.product.exceptions.ResourceNotFoundException;
import com.integrant.recommendation.product.model.Product;
import com.integrant.recommendation.product.model.ProductPage;
import com.integrant.recommendation.product.service.ProductServiceImp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * The Class ProductController.
 */
@Api(value="Operations pertaining to Product Management")
@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieved list"),
		@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})
@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ProductController {/**

		/** The product service. */
		@Autowired
		private ProductServiceImp productService;

		/**
		 * Save new product.
		 *
		 * @param productDto the product dto
		 * @return the response entity
		 * @throws BadRequestException the bad request exception
		 */
		@ApiOperation(value = "Add new Product Category")
		@PostMapping("/products")
		public ResponseEntity<Object> saveNewProduct(@Validated @RequestBody ProductDto productDto) throws BadRequestException {
			
			productService.validateProductDto(productDto);
			
			Product product = productDto.build(productDto.getCategoryId());

			Integer productId = productService.saveProduct(product);

			Map<String, Object> body = new LinkedHashMap<>();

			body.put("productId", productId);

			return new ResponseEntity<>(body, HttpStatus.OK);
		}

		/**
		 * Gets the all products.
		 *
		 * @return the all products
		 */
		@ApiOperation(value = "View a list of available products", response = List.class)
		@GetMapping("/products")
		public List<Product> getAllProducts() {

			return productService.findAllProducts();
		}

		/**
		 * Gets the product by id.
		 *
		 * @param id the id
		 * @return the product by id
		 * @throws ResourceNotFoundException 
		 */
		@ApiOperation(value = "get Product by Id")
		@GetMapping("/products/{id}")
		public Product getProductById(@Validated @PathVariable Integer id) throws ResourceNotFoundException {

			return productService.findProduct(id);
		}
		
		/**
		 * Gets the product categories by offset and limit.
		 *
		 * @param offset the offset
		 * @param limit the limit
		 * @return the product categories by offset and limit
		 */
		@ApiOperation(value = "get List of Products by Offset and Limit")
		@GetMapping("/products/page")
		public ProductPage getProductsOffsetAndLimit(@Validated @RequestParam Integer offset, @Validated @RequestParam Integer limit) {

			return productService.findProductsByOffsetAndLimit(offset, limit);
		}
		
		/**
		 * Gets the product categories by offset and limit.
		 *
		 * @param offset the offset
		 * @param limit the limit
		 * @return the product categories by offset and limit
		 */
		@ApiOperation(value = "get List of Products by Category, Offset and Limit")
		@GetMapping("/categories/{id}/products")
		public ProductPage getProductsByCategoryIdOffsetAndLimit(@Validated @PathVariable Integer id, @Validated @RequestParam Integer offset, @Validated @RequestParam Integer limit) {

			return productService.findProductsByCategoryOffsetAndLimit(id, offset, limit);
		}
		
		/**
		 * Update product.
		 *
		 * @param product the product
		 * @throws BadRequestException the bad request exception
		 */
		@ApiOperation(value = "update Product")
		@PutMapping("/products")
		public void updateProduct(@Validated @RequestBody Product product) throws BadRequestException {

			productService.validateProduct(product);
			
			productService.updateProduct(product);
		}
		
		/**
		 * Delete product by id.
		 *
		 * @param id the id
		 * @throws ResourceNotFoundException 
		 */
		@ApiOperation(value = "delete Product by Id")
		@DeleteMapping("/products/{id}")
		public void deleteProductById(@Validated @PathVariable Integer id) throws ResourceNotFoundException {

			productService.deleteProduct(id);
		}

}
