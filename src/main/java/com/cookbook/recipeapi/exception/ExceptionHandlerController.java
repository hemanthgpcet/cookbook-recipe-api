package com.cookbook.recipeapi.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.cookbook.recipeapi.util.DateTimeUtility;

/**
 * All type of Exceptions and errors will be handled in this class
 * 
 * @author heman
 *
 */

@ControllerAdvice
public class ExceptionHandlerController {
	
	private static final Logger logger = LogManager.getLogger(ExceptionHandlerController.class);
	
	/**
	 * Returns Custom Exception Details Along with the status when a record is not
	 * found in the database
	 * 
	 * @param exception - message related to exception
	 * @param request   - request url details
	 * @return - custom exception and status NOT_FOUND message
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> toHandleResourceNotFound(ResourceNotFoundException exception, WebRequest request) {
		logger.debug("Invoke toHandleResourceNotFound() method with ResourceNotFoundException:{} ", () -> exception);
		ErrorDescription error = new ErrorDescription(exception.getMessage(), request.getDescription(false),
				DateTimeUtility.getLocalDateTime());
		logger.debug("Exit from toHandleResourceNotFound() method with ErrorDescription:{}", () -> error);
		return new ResponseEntity<ErrorDescription>(error, HttpStatus.NOT_FOUND);
	}

	/**
	 * Returns Custom Validation Details Along with the status
	 * 
	 * @param exception - detailed message related to exception
	 * @return - custom exception details along with status BAD_REQUEST
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> toHandleAllCustomValidations(MethodArgumentNotValidException exception) {
		logger.debug("Invoke toHandleAllCustomValidations() method with MethodArgumentNotValidException:{} ",
				() -> exception);
		ErrorDescription error = new ErrorDescription("Parameter validation failed",
				exception.getBindingResult().getFieldError().getField() + "--"
						+ exception.getBindingResult().getFieldError().getDefaultMessage(),
						DateTimeUtility.getLocalDateTime());
		logger.debug("Exit from toHandleAllCustomValidations() method with ErrorDescription:{}", () -> error);
		return new ResponseEntity<ErrorDescription>(error, HttpStatus.BAD_REQUEST);
	}


}
