package com.capitole.technicaltest.application.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class ErrorMessageDto.
 * Used for response when an exception is generated
 */
@Setter
@Getter
public class ErrorMessageDto {
	
	/** The error type. */
	private String errorType;
	
	/** The message. */
	private String message;
}
