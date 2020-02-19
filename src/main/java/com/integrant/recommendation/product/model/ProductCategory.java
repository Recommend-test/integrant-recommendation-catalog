package com.integrant.recommendation.product.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ProductCategory.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="PRODUCT_CATEGORY")
public class ProductCategory implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@Column(name="category_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	/** The category name. */
	@Column(name="category_name")
	private String categoryName;
	
	/** The products. */
	@OneToMany(mappedBy="category")
	@JsonIgnore
	private List<Product> products;

	/**
	 * Instantiates a new product category.
	 *
	 * @param id the id
	 */
	public ProductCategory(Integer id) {
		this.id = id;
	}

	/**
	 * Instantiates a new product category.
	 *
	 * @param categoryName the category name
	 */
	public ProductCategory(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * Instantiates a new product category.
	 *
	 * @param id the id
	 * @param categoryName the category name
	 */
	public ProductCategory(Integer id, String categoryName) {
		this.id = id;
		this.categoryName = categoryName;
	}
}



