package com.naga.shopping.util;

/**
 * Thrown to indicate that a method has been passed an illegal or inappropriate
 * argument
 *
 * @author Naga
 * 
 */
public class IllegialShoppingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3532936405167960142L;

	public IllegialShoppingException() {
		super();
	}

	public IllegialShoppingException(String s) {
		super(s);
	}

}
