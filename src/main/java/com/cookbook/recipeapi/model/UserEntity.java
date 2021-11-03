package com.cookbook.recipeapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * This class is used to create cookbook_users Entity
 * 
 * @author heman
 *
 */

@Entity
@Table(name = "cookbook_users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", initialValue = 1, allocationSize = 1, sequenceName = "user_seq")
	@Column(name = "id")
	private Long id;
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "is_active")
	private Boolean isActive;
	@Column(name = "roles")
	private String roles;
	
	/**
	 * Default constructor
	 */
	public UserEntity(){
		
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param id
	 * @param userName
	 * @param password
	 * @param isActive
	 * @param roles
	 */
	public UserEntity(Long id, String userName, String password, Boolean isActive, String roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.isActive = isActive;
		this.roles = roles;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the roles
	 */
	public String getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
	

}
