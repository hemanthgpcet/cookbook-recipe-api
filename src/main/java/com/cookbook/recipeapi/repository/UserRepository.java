package com.cookbook.recipeapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.recipeapi.model.UserEntity;

/**
 * This user repository interface containing user associate methods
 * 
 * @author heman
 *
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	/**
	 * Methods to find th user by name
	 * 
	 * @param username
	 *
	 */	
	Optional<UserEntity> findByUserName(String username);

}
