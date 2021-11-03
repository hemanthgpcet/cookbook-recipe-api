package com.cookbook.recipeapi.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cookbook.recipeapi.dto.UsersDTO;
import com.cookbook.recipeapi.model.UserEntity;

/**
 * This Jwt token Junit class
 * 
 * @author heman
 *
 */

@ExtendWith(SpringExtension.class)

@SpringBootTest
 class JwtTest {
	
	@InjectMocks
	private Jwt jwt;
    
	/**
	 * Test Jwt token with Junit 
	 *
	 */

	
	@Test
	@DisplayName("Test case for Jwt token validation")
	 void generateToken() {
		UserEntity user = new UserEntity(Long.valueOf("1"), "kumar", "pass456", true, "admin");
		String token = jwt.generateToken(new UsersDTO(user));
		assertNotNull(token);
		assertNotNull(jwt.extractUsername(token));
		assertTrue(jwt.validateToken(token, new UsersDTO(user)));
	}
}

