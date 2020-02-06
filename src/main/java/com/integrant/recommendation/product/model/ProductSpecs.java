//package com.integrant.recommendation.product.model;
//
//import java.io.Serializable;
//
//import org.springframework.data.mongodb.core.mapping.Field;
//
///**
// * The Class ProductSpecs.
// */
//public class ProductSpecs implements Serializable{
//	
//	/** The Constant serialVersionUID. */
//	private static final long serialVersionUID = 1L;
//
//	/** The size. */
//	@Field("size")
//	private String size;
//	
//	/** The product color. */
//	@Field("product_color")
//	private String productColor;
//	
//	/** The product price. */
//	@Field("product_price")
//	private String productPrice;
//	
//	/** The image url. */
//	@Field("image_url")
//	private String imageUrl;
//
//	/**
//	 * Instantiates a new product specs.
//	 *
//	 * @param size the size
//	 * @param productColor the product color
//	 * @param productPrice the product price
//	 * @param imageUrl the image url
//	 */
//	public ProductSpecs(String size, String productColor, String productPrice, String imageUrl) {
//		this.size = size;
//		this.productColor = productColor;
//		this.productPrice = productPrice;
//		this.imageUrl = imageUrl;
//	}
//
//	/**
//	 * Gets the size.
//	 *
//	 * @return the size
//	 */
//	public String getSize() {
//		return size;
//	}
//
//	/**
//	 * Gets the product color.
//	 *
//	 * @return the product color
//	 */
//	public String getProductColor() {
//		return productColor;
//	}
//
//	/**
//	 * Gets the product price.
//	 *
//	 * @return the product price
//	 */
//	public String getProductPrice() {
//		return productPrice;
//	}
//
//	/**
//	 * Gets the image url.
//	 *
//	 * @return the image url
//	 */
//	public String getImageUrl() {
//		return imageUrl;
//	}
//
//	/**
//	 * To string.
//	 *
//	 * @return the string
//	 */
//	@Override
//	public String toString() {
//		return "ProductSpecs [size=" + size + ", productColor=" + productColor + ", productPrice=" + productPrice
//				+ ", imageUrl=" + imageUrl + "]";
//	}
//}
