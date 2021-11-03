package com.cookbook.recipeapi.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * I am Entity model class with Ingredients associated data members.
 * 
 * @author heman
 */

@Entity
@Table(name = "ingredients")
public class Ingredients implements Serializable {

	/**
	 * This is serial version UID for ingredients class
	 */
	private static final long serialVersionUID = 8425705945137495916L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredients_id")
	@SequenceGenerator(name = "ingredients_id", sequenceName = "ingredients_id", initialValue = 1, allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@NotNull
	@NotBlank
	@Size(min = 4, message = "Must be atleast 4 alphabets")
	@Column(name = "name")
	private String name;
	
	/**
	 * Default constructor
	 */
	
	public Ingredients()
	{
		
	}

	/**
	 * @param id
	 * @param name
	 */
	public Ingredients(Long id,
			@NotNull @NotBlank @Size(min = 4, message = "Must be atleast 4 alphabets") String name) {
		super();
		this.id = id;
		this.name = name;
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



}
