package com.capitole.technicaltest.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class ApplicationDateRangeDto.
 * Used by response for date ranges
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@ToString
public class ApplicationDateRangeDto {
	
	/** The type. */
	@JsonProperty("type")
	private String type;
	
	/** The value. */
	@JsonProperty("value")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String value;
}
