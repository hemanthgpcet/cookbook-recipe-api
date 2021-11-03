package com.cookbook.recipeapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cookbook.recipeapi.dto.RecipeDTO;
import com.cookbook.recipeapi.service.CookbookService;

/**
 * This is a Controller class for CRUD operations
 * 
 * @author heman
 */

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/cookbook")
public class CookbookController {
	
	
	  @Autowired
	  private CookbookService cookbookService;


		

	  @GetMapping(value="/")
	  public List<RecipeDTO> getAllRecipe() {
			return cookbookService.getAllRecipes();
		}
	  
	  /**
		 * GetRecipe by recipe ID
		 * 
		 * @param id - Recipe id of the recipe
		 * @return Recipe object
		 */
	  @GetMapping(value="/id={id}")
	  public RecipeDTO findRecipe(@PathVariable Long id) {
		  return cookbookService.findRecipeById(id);
	  }
	  
	  /**
			 * GetRecipe by Expected rating of the recipe
			 * 
			 * @param rating 
			 * @return Recipe object
			 */
	  @GetMapping(value="/rating={rating}")
	  public List<RecipeDTO> findByIdrating(@PathVariable Integer rating)
		  { 
		  return cookbookService.findByCustomerrating(rating);
		  }
	  
	  /**
		 * GetRecipe by numberofpeopl the recipe is sufficent
		 * 
		 * @param id
		 * @return Recipe object
		 */
	  @GetMapping(value="/numberofpeople={numberofpeople}")
	  public List<RecipeDTO> findBySufficiency(@PathVariable Integer numberofpeople)
		  { 
		  return cookbookService.findBySufficiency(numberofpeople);
		  }
	  
	  
		
	  /**
		 * Insert new Recipe details, ingredients with cooking instructions.
		 * 
		 * @param recipe
		 */
	  @PostMapping("/")
		public String insertRecipe(@Valid @RequestBody RecipeDTO recipeDto) {
		  return cookbookService.saveRecipe(recipeDto);
			 
		}
	  
	  
	  /**
		 * Update existing Recipe details, ingredients with cooking instructions.
		 * 
		 * @param recipe
		 * @param id
		 * @return - Recipe Object updated.
		 */
	  @PutMapping("/{id}")
	  public RecipeDTO updateRecipe(@Valid @RequestBody RecipeDTO recipeDTO, @PathVariable Long id) {
			return cookbookService.updateRecipe(recipeDTO, id);

		}
	  
	  /**
		 * Delete existing Recipe details by passing recipe id.
		 * 
		 * @param id - Recipe ID
		 * @return returns HTTP response as OK
		 */
	  @DeleteMapping("/{id}")
		public ResponseEntity<RecipeDTO> deleteRecipe(@PathVariable Long id) {
			cookbookService.deleteRecipeById(id);
			return ResponseEntity.ok().build();
		}

}

