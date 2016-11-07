/**
 * 
 */
package com.project.hotel.exception;

/**
 * @author prakashnayak
 *
 */
public class RoomsNotAvailableException extends Exception {

	public RoomsNotAvailableException(String message, Throwable cause) {
		super(message, cause);
	}

	public RoomsNotAvailableException(String message) {
		super(message);
	}

	public RoomsNotAvailableException(Throwable cause) {
		super(cause);
	}
	
	

}
