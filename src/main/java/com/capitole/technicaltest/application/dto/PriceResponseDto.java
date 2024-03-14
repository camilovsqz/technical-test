package com.capitole.technicaltest.application.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PriceResponseDto{
	@JsonProperty("productId")
	private int productId;
	@JsonProperty("brandId")
	private int brandId;
	@JsonProperty("rateToApply")
	private int rateToApply;
	@JsonProperty("applicationDateRange")
	private List<ApplicationDateRangeDto> applicationDateRange;
	@JsonProperty("finalPrice")
	private double finalPrice;
	
}
