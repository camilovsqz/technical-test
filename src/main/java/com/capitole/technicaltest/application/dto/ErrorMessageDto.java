package com.capitole.technicaltest.application.dto;

import lombok.Data;

@Data
public class ErrorMessageDto {
	private String errorType;
	private String message;
}
