package com.capitole.technicaltest.application.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceResponseDto {
	private int productId;
	private int brandId;
	private int rateToApply;
	private List<ApplicationDataRangeDto> applicationDataRange;
	private double finalPrice;
}
