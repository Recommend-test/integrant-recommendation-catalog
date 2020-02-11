package com.integrant.recommendation.product.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.integrant.recommendation.product.model.ProductCategory;
import com.integrant.recommendation.product.service.ProductServiceImp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Class ProductCatalogController.
 */

@Api(value="Operations pertaining to Product Categories Management")
@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieved list"),
		@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})
@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ProductCategoryController {

	/** The product service. */
	@Autowired
	private ProductServiceImp productService;

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Save new catalog.
	 *
	 * @param productCatalogDto the product category dto
	 */
	@ApiOperation(value = "Add new Product Category")
	@PostMapping("/categories")
	public ResponseEntity<Object> saveNewCategory(@Validated @RequestBody ProductCategory productCategoryDto) {

		Integer productCategoryId = productService.saveProductCategory(productCategoryDto);

		Map<String, Object> body = new LinkedHashMap<>();

		body.put("productCategoryId", productCategoryId);

		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	/**
	 * Gets the all catalogs.
	 *
	 * @return the all catalogs
	 */
	@ApiOperation(value = "View a list of available product Categories", response = List.class)
	@GetMapping("/categories")
	public List<ProductCategory> getAllCategories() {

		return productService.findAllProductCategories();
	}

	/**
	 * Gets the all catalogs.
	 *
	 * @param id the id
	 * @return the all catalogs
	 */
	@ApiOperation(value = "get Product Category by Id")
	@GetMapping("/categories/{id}")
	public ProductCategory getProductCategoryById(@Validated @PathVariable Integer id) {

		return productService.findProductCategory(id);
	}
	
	@ApiOperation(value = "get List of Product Category by Offset and Limit")
	@GetMapping("/categories/page")
	public List<ProductCategory> getProductCategoriesByOffsetAndLimit(@Validated @RequestParam Integer offset, @Validated @RequestParam Integer limit) {

		return productService.findProductCategoryByOffsetAndLimit(offset, limit);
	}
	
	@ApiOperation(value = "update Product Category")
	@PutMapping("/categories")
	public void updateProductCategoryById(@Validated @RequestBody ProductCategory productCategory) {

		
		productService.updateProductCategory(productCategory);
	}
	
	@ApiOperation(value = "delete Product Category by Id")
	@DeleteMapping("/categories/{id}")
	public void deleteProductCategoryById(@Validated @PathVariable Integer id) {

		productService.deleteProductCategory(id);
	}
}
