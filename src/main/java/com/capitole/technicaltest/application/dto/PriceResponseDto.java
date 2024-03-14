package com.capitole.technicaltest.application.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * The Class PriceResponseDto.
 * Used by GET response
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

/**
 * The Class PriceResponseDtoBuilder.
 */
@Builder
@ToString
public class PriceResponseDto{
	
	/** The product id. */
	@JsonProperty("productId")
	private int productId;
	
	/** The brand id. */
	@JsonProperty("brandId")
	private int brandId;
	
	/** The rate to apply. */
	@JsonProperty("rateToApply")
	private int rateToApply;
	
	/** The application date range. */
	@JsonProperty("applicationDateRange")
	private List<ApplicationDateRangeDto> applicationDateRange;
	
	/** The final price. */
	@JsonProperty("finalPrice")
	private double finalPrice;
	
}
