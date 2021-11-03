package com.cookbook.recipeapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.recipeapi.model.Recipe;

/**
 * This recipe repository interface containing database queries as methods in JpaRepository.
 * 
 * @author heman
 *
 */


public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	
	/**
	 * Methods to retrive recipe by rating
	 * 
	 * @param rating
	 *
	 */
	List<Recipe> findByrating(Integer rating);
	
	/**
	 * Methods to retrive recipe by numberofpeople
	 * 
	 * @param numberOfPeople
	 *
	 */
	
	List<Recipe> findBynumberOfPeople(Integer numberOfPeople);


}
