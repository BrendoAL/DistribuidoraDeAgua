package com.lambda.Javagua.Exception;

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

	public BusinessException (String message) {
		super(message);
	}
}
