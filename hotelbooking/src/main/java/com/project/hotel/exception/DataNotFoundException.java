/**
 * 
 */
package com.project.hotel.exception;

/**
 * @author prakashnayak
 *
 */
public class DataNotFoundException extends Exception {

	public DataNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataNotFoundException(String message) {
		super(message);
	}

	public DataNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
