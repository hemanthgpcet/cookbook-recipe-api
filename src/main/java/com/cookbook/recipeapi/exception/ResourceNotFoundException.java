package com.cookbook.recipeapi.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Custom exception for resource not found 404
 * 
 * @author heman
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private static final Logger logger = LogManager.getLogger(ResourceNotFoundException.class);

	private static final long serialVersionUID = 1L;
	

	/**
	 * Parameterized constructor
	 * 
	 * @param message
	 */
	public ResourceNotFoundException(String message) {
		super(message);
		logger.debug("Invoke ResourceNotFoundException() with Message:{} ", () -> message);
	}

}
