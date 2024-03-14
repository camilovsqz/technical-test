package com.capitole.technicaltest.application.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitole.technicaltest.application.constant.AppConstant;
import com.capitole.technicaltest.application.dto.ApplicationDateRangeDto;
import com.capitole.technicaltest.application.dto.PriceResponseDto;
import com.capitole.technicaltest.application.dto.SearchParamsDto;
import com.capitole.technicaltest.application.service.PriceService;
import com.capitole.technicaltest.application.util.DateUtil;
import com.capitole.technicaltest.domain.model.Price;
import com.capitole.technicaltest.domain.port.PricePercistencePort;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PricePercistencePort pricePercistencePort;

	@Override
	public Optional<PriceResponseDto> searchPrice(SearchParamsDto params) {
		List<Price> priceList = pricePercistencePort.findAllByAplicationDateAndProductIdAndBrandId(
				params.getApplicationDate(), params.getProductIdentifier(), params.getBrandIdentifier());

		if (priceList.isEmpty()) {
			return Optional.empty();
		}

		Price pricePriority = priceList.stream().max((p1, p2) -> Integer.compare(p1.getPriority(), p2.getPriority()))
				.get();

		ApplicationDateRangeDto startDate = new ApplicationDateRangeDto().builder().type(AppConstant.START_DATE)
				.value(DateUtil.dateToStringFormat(pricePriority.getStartDate())).build();
		ApplicationDateRangeDto endDate = new ApplicationDateRangeDto().builder().type(AppConstant.END_DATE)
				.value(DateUtil.dateToStringFormat(pricePriority.getEndDate())).build();

		PriceResponseDto priceResponseDto = new PriceResponseDto().builder().productId(pricePriority.getProductId())
				.brandId(pricePriority.getBrandId()).rateToApply(pricePriority.getPriceList())
				.applicationDateRange(new ArrayList<>(Arrays.asList(startDate, endDate)))
				.finalPrice(pricePriority.getPrice()).build();
		return Optional.ofNullable(priceResponseDto);
	}

}
