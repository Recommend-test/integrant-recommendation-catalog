package com.integrant.recommendation.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class ProductCatalogApplication.
 */
@SpringBootApplication
public class ProductCategoryApplication {



	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		/** The logger. */
		Logger logger = LoggerFactory.getLogger(ProductCategoryApplication.class);

		try {

			SpringApplication.run(ProductCategoryApplication.class, args);

			logger.info("Application Started Successfully");

		} catch (Exception e) {

			logger.error("Error occured while starting the applicaion");	
		}
	}

}
