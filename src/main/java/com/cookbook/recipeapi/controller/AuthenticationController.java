package com.cookbook.recipeapi.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cookbook.recipeapi.dto.AuthenticationRequest;
import com.cookbook.recipeapi.dto.AuthenticationResponse;
import com.cookbook.recipeapi.util.Jwt;


/**
 * 
 * This is a controller for authentication
 * 
 * @author heman
 *
 */
@RestController
public class AuthenticationController {
	
	private static final Logger logger = LogManager.getLogger(AuthenticationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService myUserDetailsService;

	@Autowired
	private Jwt jwtUtil;

	/**
	 * This method authenticate the user and return a JWT Token.
	 * 
	 * @param authenticationRequest
	 * @throws Exception
	 */
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		logger.debug("Invoke createAuthenticationToken() method with AuthenticationRequest:{} ", () -> authenticationRequest);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		logger.debug("Exit createAuthenticationToken() method.");
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	

}
