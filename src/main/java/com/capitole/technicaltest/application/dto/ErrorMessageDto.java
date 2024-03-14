package com.capitole.technicaltest.application.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorMessageDto {
	private String errorType;
	private String message;
}
