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

import com.integrant.recommendation.product.dto.CategoryDto;
import com.integrant.recommendation.product.exceptions.BadRequestException;
import com.integrant.recommendation.product.exceptions.DataConflictException;
import com.integrant.recommendation.product.exceptions.ResourceNotFoundException;
import com.integrant.recommendation.product.model.ProductCategory;
import com.integrant.recommendation.product.model.ProductCategoryPage;
import com.integrant.recommendation.product.service.CategoryServiceImp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Class CategoryController.
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
public class CategoryController {

	/** The product service. */
	@Autowired
	private CategoryServiceImp categoryService;

	/**
	 * Save new catalog.
	 *
	 * @param productCategoryDto the product category dto
	 * @return the response entity
	 * @throws BadRequestException the bad request exception
	 */
	@ApiOperation(value = "Add new Product Category")
	@PostMapping("/categories")
	public ResponseEntity<Object> saveNewCategory(@Validated @RequestBody CategoryDto productCategoryDto) throws BadRequestException {
		
		categoryService.validateProductCategoryDto(productCategoryDto);

		Integer productCategoryId = categoryService.saveProductCategory(productCategoryDto.build());

		Map<String, Object> body = new LinkedHashMap<>();

		body.put("productCategoryId", productCategoryId);

		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}

	/**
	 * Gets the all catalogs.
	 *
	 * @return the all catalogs
	 */
	@ApiOperation(value = "View a list of available product Categories", response = List.class)
	@GetMapping("/categories")
	public List<ProductCategory> getAllCategories() {

		return categoryService.findAllProductCategories();
	}

	/**
	 * Gets the all catalogs.
	 *
	 * @param id the id
	 * @return the all catalogs
	 * @throws ResourceNotFoundException 
	 */
	@ApiOperation(value = "get Product Category by Id")
	@GetMapping("/categories/{id}")
	public ProductCategory getProductCategoryById(@Validated @PathVariable Integer id) throws ResourceNotFoundException {

		return categoryService.findProductCategory(id);
	}
	
	/**
	 * Gets the product categories by offset and limit.
	 *
	 * @param offset the offset
	 * @param limit the limit
	 * @return the product categories by offset and limit
	 */
	@ApiOperation(value = "get List of Product Category by Offset and Limit")
	@GetMapping("/categories/page")
	public ProductCategoryPage getProductCategoriesByOffsetAndLimit(@Validated @RequestParam Integer offset, @Validated @RequestParam Integer limit) {

		return categoryService.findProductCategoryByOffsetAndLimit(offset, limit);
	}
	
	/**
	 * Update product category by id.
	 *
	 * @param productCategory the product category
	 * @throws BadRequestException the bad request exception
	 */
	@ApiOperation(value = "update Product Category")
	@PutMapping("/categories")
	public void updateProductCategory(@Validated @RequestBody CategoryDto productCategoryDto) throws BadRequestException {

		categoryService.validateProductCategoryForUpdate(productCategoryDto);
		
		categoryService.updateProductCategory(productCategoryDto.buildForUpdate());
	}
	
	/**
	 * Delete product category by id.
	 *
	 * @param id the id
	 * @throws DataConflictException the data conflict exception
	 * @throws ResourceNotFoundException 
	 */
	@ApiOperation(value = "delete Product Category by Id")
	@DeleteMapping("/categories/{id}")
	public void deleteProductCategoryById(@Validated @PathVariable Integer id) throws DataConflictException, ResourceNotFoundException {

		categoryService.deleteProductCategory(id);
	}
}
