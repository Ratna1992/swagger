package com.boot.ratna.txmgmt.exceptions;

public class NoCreditAvailableException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoCreditAvailableException(String errorMessage) {
		super(errorMessage);
	}

}
