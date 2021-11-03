package com.cookbook.recipeapi.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * This DTO class containing Recipe related data members.
 * 
 * @author heman
 *
 */

public class RecipeDTO {
	
	private Long id;
	@NotNull(message="name should not be null")
	private String name;
	@Min(value = 1, message = "Number of people should be minimum 1 person")
	private Integer numberOfPeople;
	private Integer rating;
	private String createdDateTime;
	private Boolean isVegetarian;
	private List<IngredientsDTO> ingredientsList;
	private String cookingInstructions;
	private String mastercheftips;
	
	
	/**
	 * Default constructor
	 */
	public RecipeDTO() {
	}
	
	

	/**
	 * @param id
	 * @param name
	 * @param numberOfPeople
	 * @param rating
	 * @param createdDateTime
	 * @param isVegetarian
	 * @param ingredientsList
	 * @param cookingInstructions
	 * @param mastercheftips
	 */
	public RecipeDTO(Long id, String name, Integer numberOfPeople, Integer rating, String createdDateTime,
			Boolean isVegetarian, List<IngredientsDTO> ingredientsList, String cookingInstructions,
			String mastercheftips) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfPeople = numberOfPeople;
		this.rating = rating;
		this.createdDateTime = createdDateTime;
		this.isVegetarian = isVegetarian;
		this.ingredientsList = ingredientsList;
		this.cookingInstructions = cookingInstructions;
		this.mastercheftips = mastercheftips;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the numberOfPeople
	 */
	public Integer getNumberOfPeople() {
		return numberOfPeople;
	}



	/**
	 * @param numberOfPeople the numberOfPeople to set
	 */
	public void setNumberOfPeople(Integer numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}



	/**
	 * @return the rating
	 */
	public Integer getRating() {
		return rating;
	}



	/**
	 * @param rating the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}



	/**
	 * @return the createdDateTime
	 */
	public String getCreatedDateTime() {
		return createdDateTime;
	}



	/**
	 * @param createdDateTime the createdDateTime to set
	 */
	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}



	/**
	 * @return the isVegetarian
	 */
	public Boolean getIsVegetarian() {
		return isVegetarian;
	}



	/**
	 * @param isVegetarian the isVegetarian to set
	 */
	public void setIsVegetarian(Boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}



	/**
	 * @return the ingredientList
	 */
	public List<IngredientsDTO> getIngredientsList() {
		return ingredientsList;
	}



	/**
	 * @param ingredientsList the ingredientsList to set
	 */
	public void setIngredientsList(List<IngredientsDTO> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}



	/**
	 * @return the cookingInstructions
	 */
	public String getCookingInstructions() {
		return cookingInstructions;
	}



	/**
	 * @param cookingInstructions the cookingInstructions to set
	 */
	public void setCookingInstructions(String cookingInstructions) {
		this.cookingInstructions = cookingInstructions;
	}



	/**
	 * @return the mastercheftips
	 */
	public String getMastercheftips() {
		return mastercheftips;
	}



	/**
	 * @param mastercheftips the mastercheftips to set
	 */
	public void setMastercheftips(String mastercheftips) {
		this.mastercheftips = mastercheftips;
	}



	
	

	

}
