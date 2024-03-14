package com.capitole.technicaltest.application.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@ToString
public class ApplicationDateRangeDto {
	@JsonProperty("type")
	private String type;
	@JsonProperty("value")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String value;

}
