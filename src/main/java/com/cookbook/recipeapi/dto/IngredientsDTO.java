package com.cookbook.recipeapi.dto;

/**
 * This DTO class is containing ingredient related data members.
 * 
 * @author heman
 *
 */
public class IngredientsDTO {

	private Long id;
	private String name;
	
	/**
	 * Default constructor
	 */
	public IngredientsDTO() {
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
	 * @param id
	 * @param name
	 */
	public IngredientsDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	
	
}
