package com.integrant.recommendation.product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class Product.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="PRODUCT")
public class Product implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	/** The product name. */
	@Column(name="product_name")
	private String productName;

	/** The product description. */
	@Column(name="description")
	private String productDescription;

	/** The category. */
	@ManyToOne
	@JoinColumn(name="category_id", nullable=false)
	@JsonIgnore
	private ProductCategory category;


	/**
	 * Instantiates a new product.
	 *
	 * @param productName the product name
	 * @param productDescription the product description
	 * @param category the category
	 */
	public Product(String productName, String productDescription, ProductCategory category) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.category = category;
	}
}

