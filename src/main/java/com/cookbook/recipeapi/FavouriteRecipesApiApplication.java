package com.cookbook.recipeapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * This is class containing main method for recipe-data-api application.
 * 
 * @author heman
 *
 */
@SpringBootApplication
public class FavouriteRecipesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavouriteRecipesApiApplication.class, args);
	}
	
	/**
	 * This bean is used for ModelMapper bean definition.
	 * 
	 * @return ModelMapper class object
	 */

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
