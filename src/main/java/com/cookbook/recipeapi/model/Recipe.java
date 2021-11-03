package com.cookbook.recipeapi.model;
import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.List;

/**
 * I am Entity model class with Recipe associated data members.
 * 
 * @author heman
 */

@Entity
@Table(name = "cookbook")
public class Recipe implements Serializable {
	
	    
	/**
	 * This is serial version UID for recipe class
	 */	
	    private static final long serialVersionUID = 4048749402439937910L;

		@Id
		@GeneratedValue(generator = "recipe_seq", strategy = GenerationType.SEQUENCE)
		@SequenceGenerator(name = "recipe_seq", sequenceName = "recipe_seq", initialValue = 1, allocationSize = 1)
		private Long id;
		
		@NotNull
		@NotBlank
		@Column(name = "name")
		private String name;
        
		@Min(value = 1, message = "Number of people should be minimum 1 person")
		@Column(name = "number_of_people")
		private Integer numberOfPeople;
		
		@Range(min=1,max=5,message = "rating should be between 1-5")
		@Column(name = "rating_by_customers")
		private Integer rating;
		
		@Column(name = "created_date_time")
		private String createdDateTime;
		
		@Column(name = "is_vegetarian")
		private Boolean isVegetarian;
		
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name = "recipe_id", nullable = false)
		private List<Ingredients> ingredientsList;
		
		@NotNull
		@NotBlank
		@Column(name = "cooking_instructions")
		private String cookingInstructions;
		
		@Column(name="masterchef_tips")
		private String mastercheftips;

		/**
		 * Default constructor
		 */
		public Recipe() {
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
		public Recipe(Long id, @NotNull @NotBlank String name,
				@Min(value = 1, message = "Number of people should be minimum 1 person") Integer numberOfPeople,
				@Range(min = 1, max = 5, message = "rating should be between 1-5") Integer rating, String createdDateTime,
				Boolean isVegetarian, List<Ingredients> ingredientsList, @NotNull @NotBlank String cookingInstructions,
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
		 * @return the ingredientsList
		 */
		public List<Ingredients> getIngredientsList() {
			return ingredientsList;
		}

		/**
		 * @param ingredientsList the ingredientsList to set
		 */
		public void setIngredientsList(List<Ingredients> ingredientsList) {
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
