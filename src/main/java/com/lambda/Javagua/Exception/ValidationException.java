package com.lambda.Javagua.Exception;

@SuppressWarnings("serial")
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
