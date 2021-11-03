package com.cookbook.recipeapi.exception;

/**
 *  Error model with custom Exceptions, message, timeStamp
 * 
 * @author heman
 *
 */
public class ErrorDescription {
	
	private String message;
	private String desc;
	private String timeStamp;
	
	/**
	 * Default constructor
	 */
	
	public ErrorDescription() {
	}
	
	/**
	 * Parameterized constructor
	 * 
	 * @param message
	 * @param details
	 * @param timeStamp
	 */
	public ErrorDescription(String message, String desc, String timeStamp) {
		super();
		this.message = message;
		this.desc = desc;
		this.timeStamp = timeStamp;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the timeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	
	
	

}
