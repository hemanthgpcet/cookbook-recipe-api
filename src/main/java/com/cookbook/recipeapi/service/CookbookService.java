package com.cookbook.recipeapi.service;

import java.util.List;

import com.cookbook.recipeapi.dto.RecipeDTO;

/**
 *All the abstarct methods are declared in this interface.
 *
 * @author heman
 */
public interface CookbookService {
	
	
	/**
	 * Get List of all Recipes which are present in database table.
	 * 
	 * @return List<Recipe>
	 */
	public List<RecipeDTO> getAllRecipes();
	
	/**
	 * Get single Recipe by passing recipe ID
	 * 
	 * @param id
	 * @return Recipe
	 */
	
	RecipeDTO findRecipeById(Long id);
	
	/**
	 * Get Recipe by average customer rating
	 * 
	 * @param rating
	 * @return List<Recipe>
	 */
	List<RecipeDTO> findByCustomerrating(Integer rating);
	
	
	/**
	 * Get  Recipe by sufficiency 
	 * 
	 * @param numberofpeople
	 * @return List<Recipe>
	 */
	List<RecipeDTO> findBySufficiency(Integer numberofpeople);
	
	/**
	 * Save new Recipe details, ingredients with cooking instructions etc...
	 */
    String saveRecipe(RecipeDTO recipeDTO);
    
    /**
	 * Update existing Recipe details.
	 * @param recipe - All the details of recipe like name, type, vegetarian, etc..
	 * @param id - Recipe ID
	 * @return - Recipe Object updated.
	 */
	RecipeDTO updateRecipe(RecipeDTO recipeDto, Long id);
	
	/**
	 * Delete existing Recipe details by passing recipe id.
	 * @param id - Recipe ID
	 */
	String deleteRecipeById(Long id);

}
