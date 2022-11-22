package com.ratna.mongo.boot.exceptions;

public class TodoCollectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TodoCollectionException(String msg) {
		super(msg);
	}

	public static String NotFoundException(String id) {
		return "no todo with given id:: " + id;
	}

	public static String TodoAlreadyExists(String name) {
		return "already a todo available with given name:: " + name;
	}

}
