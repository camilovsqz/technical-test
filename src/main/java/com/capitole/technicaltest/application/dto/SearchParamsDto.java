package com.capitole.technicaltest.application.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class SearchParamsDto.
 * Used by GET params request
 */
@Getter
@Setter
@ToString
public class SearchParamsDto {
	
	/** The application date. */
	@NotNull(message = "applicationDate field is required")
	@DateTimeFormat(iso = ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date applicationDate;
    
    /** The product identifier. */
    @Min(value = 1, message = "productIdentifier field is required")
	private int productIdentifier;
    
    /** The brand identifier. */
    @Min(value = 1, message = "brandIdentifier field is required")
	private int brandIdentifier;
}

