//package com.integrant.recommendation.product.model;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Field;
//
//import com.integrant.recommendation.product.dto.ProductCatalogDto;
//
///**
// * The Class ProductCatalog.
// */
//@Document("product_catalogs")
//public class ProductCatalog implements Serializable{
//	
//	/** The Constant serialVersionUID. */
//	private static final long serialVersionUID = 1L;
//
//	/** The id. */
//	@Field("_id")
//	private String id;
//	
//	/** The catalog name. */
//	@Field("catalog_name")
//	private String catalogName;
//	
//	/** The categories. */
//	@Field("categories")
//	private List<ProductCategory> categories;
//
//	
//	/**
//	 * Instantiates a new product catalog.
//	 */
//	public ProductCatalog() {
//	}
//
//	/**
//	 * Instantiates a new product catalog.
//	 *
//	 * @param catalogName the catalog name
//	 * @param categories the categories
//	 */
//	public ProductCatalog(String catalogName, List<ProductCategory> categories) {
//		this.id = UUID.randomUUID().toString();
//		this.catalogName = catalogName;
//		this.categories = categories;
//	}
//
//	/**
//	 * Gets the id.
//	 *
//	 * @return the id
//	 */
//	public String getId() {
//		return id;
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
//	 * Gets the categories.
//	 *
//	 * @return the categories
//	 */
//	public List<ProductCategory> getCategories() {
//		return categories;
//	}
//	
//	/**
//	 * Builds the product catalog.
//	 *
//	 * @param productCatalogDto the product catalog dto
//	 * @return the product catalog
//	 */
//	public ProductCatalog buildProductCatalog(ProductCatalogDto productCatalogDto) {
//		
//		List<ProductCategory> categories = new ArrayList<ProductCategory>();
//		
//		ProductCategory productCategory = new ProductCategory(productCatalogDto.getCategoryName(), productCatalogDto.getProducts());
//		
//		categories.add(productCategory);
//		
//		return new ProductCatalog(productCatalogDto.getCatalogName(), categories);
//		
//	}
//
//	/**
//	 * To string.
//	 *
//	 * @return the string
//	 */
//	@Override
//	public String toString() {
//		return "ProductCatalog [id=" + id + ", catalogName=" + catalogName + ", categories=" + categories + "]";
//	}
//}
//
