package com.cookbook.recipeapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cookbook.recipeapi.dto.AuthenticationRequest;
import com.cookbook.recipeapi.dto.AuthenticationResponse;
import com.cookbook.recipeapi.dto.UsersDTO;
import com.cookbook.recipeapi.model.UserEntity;
import com.cookbook.recipeapi.util.Jwt;

/**
 * This class for AuthenticationController Test
 * 
 * @author heman
 *
 */

@ExtendWith(SpringExtension.class)

@SpringBootTest
public class AuthenticationControllerTest {
	
	@InjectMocks
	private AuthenticationController authenticationController;
	
	@Mock
	private AuthenticationManager authenticationManager;

	@Mock
	private UserDetailsService UserDetailsService;

	@Mock
	private Jwt jwt;
	
	/**
	 * This test case for generate jwt token
	 * @throws Exception BadCredentialsException
	 */
	@Test
	 void testGenerateJwtToken() throws Exception {
		UserEntity user = new UserEntity();
		user.setId(1l);
		user.setIsActive(true);
		user.setPassword("pass456");
		user.setUserName("kumar");
		user.setRoles("admin");
		UsersDTO usersdto = new UsersDTO(user);
		usersdto.getAuthorities();
		usersdto.getPassword();
		usersdto.getUsername();
		usersdto.isAccountNonExpired();
		usersdto.isAccountNonLocked();
		usersdto.isCredentialsNonExpired();
		usersdto.isEnabled();
		new AuthenticationResponse("Token").getJwt();
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("hemanth", "pass123");
		when(UserDetailsService.loadUserByUsername(Mockito.anyString())).thenReturn(usersdto);
		when(jwt.generateToken(Mockito.any())).thenReturn(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoZW1hbnRoIiwiZXhwIjoxNjM1ODUyODYxLCJpYXQiOjE2MzU4NTE2NjF9.Y0YVPKK97D2npprtK5zXsKsPbeFVikKVAkwYeZ3NrSo");
		ResponseEntity<?> responseEntity = authenticationController.createAuthenticationToken(authenticationRequest);
		assertEquals(200, responseEntity.getStatusCodeValue());
	}
	
	/**
	 * This test case is for token test
	 * 
	 */
	
	@Test
	public void authenticationTokenTest() throws Exception {
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("hemanth", "pass123");
		when(authenticationManager.authenticate(Mockito.any())).thenThrow(BadCredentialsException.class);
		assertThrows(Exception.class, () -> {
			authenticationController.createAuthenticationToken(authenticationRequest);
		  });
	}
	

}
