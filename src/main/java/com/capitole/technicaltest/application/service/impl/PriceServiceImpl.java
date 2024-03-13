package com.capitole.technicaltest.application.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capitole.technicaltest.application.dto.ApplicationDataRangeDto;
import com.capitole.technicaltest.application.dto.PriceResponseDto;
import com.capitole.technicaltest.application.dto.SearchParamsDto;
import com.capitole.technicaltest.application.service.PriceService;
import com.capitole.technicaltest.domain.model.Price;
import com.capitole.technicaltest.infrastructure.outputadapter.PriceRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PriceServiceImpl implements PriceService {
private final PriceRepository priceRepository;
	
@Override
public Optional<PriceResponseDto> searchPrice(SearchParamsDto params) {
	List<Price> priceList = priceRepository.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandId(
			params.getApplicationDate(),
			params.getApplicationDate(),
			params.getProductIdentifier(),
			params.getBrandIdentifier());
	
	if (priceList.isEmpty()) {
		return Optional.empty();
	}
	
	Price pricePriority = priceList.stream().max((p1, p2) -> Integer.compare(p1.getPriority(), p2.getPriority())).get();
	
	ApplicationDataRangeDto startDate = new ApplicationDataRangeDto.Builder("START DATE", pricePriority.getStartDate()).build();
	ApplicationDataRangeDto endDate = new ApplicationDataRangeDto.Builder("END DATE", pricePriority.getStartDate()).build();
	
	PriceResponseDto priceResponseDto = new PriceResponseDto().builder()
			.productId(pricePriority.getProductId())
			.brandId(pricePriority.getBrandId())
			.rateToApply(pricePriority.getPriceList())
			.applicationDataRange(new ArrayList<> (Arrays
					.asList(startDate, endDate)))
			.finalPrice(pricePriority.getPrice())
			.build();
	return Optional.ofNullable(priceResponseDto);
}
}
