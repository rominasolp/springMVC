package com.ticketero.exception;

import java.util.List;

import org.springframework.validation.FieldError;

public class FormValidationError extends Exception {
	
	private List<FieldError> fieldErrors;

	    public FormValidationError(List<FieldError> fieldErrors) {
	        this.fieldErrors = fieldErrors;
	    }

	    public List<FieldError> getFieldErrors() {
	        return fieldErrors;
	    }
}
