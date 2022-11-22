package com.ratna.mongo.boot.exceptions;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {

	private Date dateTime;
	private String message;
	private String status;
}
