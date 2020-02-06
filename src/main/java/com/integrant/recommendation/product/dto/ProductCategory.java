//package com.integrant.recommendation.product.dto;
//
//import java.io.Serializable;
//import java.util.List;
//
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.integrant.recommendation.product.model.Product;
//
///**
// * The Class ProductCatalogDto.
// */
//@JsonInclude(JsonInclude.Include.NON_NULL)
//public class ProductCategory implements Serializable {
//
//	/** The Constant serialVersionUID. */
//	private static final long serialVersionUID = 1L;
//
//	/** The catalog name. */
//	@NotNull(message = "Catalog Name must not be null")
//	@NotEmpty(message = "Catalog Name must not be null")
//	private String catalogName;
//
//	/** The category name. */
//	@NotNull(message = "Category Name must not be null")
//	@NotEmpty(message = "Category Name must not be null")
//	private String categoryName;
//
//	/** The products. */
//	private List<Product> products;
//
//	/**
//	 * Instantiates a new product catalog dto.
//	 *
//	 * @param catalogName the catalog name
//	 * @param categoryName the category name
//	 * @param products the products
//	 */
//	public ProductCategory(String catalogName, String categoryName, List<Product> products) {
//		this.catalogName = catalogName;
//		this.categoryName = categoryName;
//		this.products = products;
//	}
//
//	/**
//	 * Gets the catalog name.
//	 *
//	 * @return the catalog name
//	 */
//	public String getCatalogName() {
//		return catalogName;
//	}
//
//	/**
//	 * Gets the category name.
//	 *
//	 * @return the category name
//	 */
//	public String getCategoryName() {
//		return categoryName;
//	}
//
//	/**
//	 * Gets the products.
//	 *
//	 * @return the products
//	 */
//	public List<Product> getProducts() {
//		return products;
//	}
//
//	/**
//	 * To string.
//	 *
//	 * @return the string
//	 */
//	@Override
//	public String toString() {
//		return "ProductCatalogDto [catalogName=" + catalogName + ", categoryName=" + categoryName + ", products="
//				+ products + "]";
//	}
//}
//
