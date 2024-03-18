package com.capitole.technicaltest.application.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitole.technicaltest.application.constant.AppConstant;
import com.capitole.technicaltest.application.constant.LogConstant;
import com.capitole.technicaltest.application.dto.ApplicationDateRangeDto;
import com.capitole.technicaltest.application.dto.PriceResponseDto;
import com.capitole.technicaltest.application.dto.SearchParamsDto;
import com.capitole.technicaltest.application.service.PriceService;
import com.capitole.technicaltest.application.util.DateUtil;
import com.capitole.technicaltest.domain.model.Price;
import com.capitole.technicaltest.domain.port.PricePercistencePort;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class PriceServiceImpl.
 * Application logic to obtain the PRICE that applies according to the request
 */
@Service
@Slf4j
public class PriceServiceImpl implements PriceService {

	/** The price percistence port. */
	private final PricePercistencePort pricePercistencePort;	
	
	/**
	 * Instantiates a new price service impl.
	 *
	 * @param pricePercistencePort the price percistence port
	 */
	public PriceServiceImpl(PricePercistencePort pricePercistencePort) {
		this.pricePercistencePort = pricePercistencePort;
	}

	/**
	 * Search price.
	 *
	 * @param params the params
	 * @return the optional
	 */
	@Override
	public Optional<PriceResponseDto> searchPrice(SearchParamsDto params) {
		List<Price> priceList = pricePercistencePort.findAllByAplicationDateAndProductIdAndBrandId(
				params.getApplicationDate(), params.getProductIdentifier(), params.getBrandIdentifier());

		if (priceList.isEmpty()) {
			log.info(LogConstant.NOT_FOUND_PRICE);
			return Optional.empty();
		}
		Price pricePriority = priceList.stream().max((p1, p2) -> Integer.compare(p1.getPriority(), p2.getPriority()))
				.get();

		ApplicationDateRangeDto startDate = createDateRangeDto(AppConstant.START_DATE, pricePriority.getStartDate());
		ApplicationDateRangeDto endDate = createDateRangeDto(AppConstant.END_DATE, pricePriority.getEndDate());

		PriceResponseDto priceResponseDto = new PriceResponseDto().builder()
				.productId(pricePriority.getProductId())
				.brandId(pricePriority.getBrandId()).rateToApply(pricePriority.getPriceList())
				.applicationDateRange(Arrays.asList(startDate, endDate))
				.finalPrice(pricePriority.getPrice()).build();
		return Optional.ofNullable(priceResponseDto);
	}

	/**
	 * Creates the date range dto.
	 * Utility method to create ApplicationDateRangeDto
	 *
	 * @param type the type
	 * @param value the value
	 * @return the application date range dto
	 */
	private ApplicationDateRangeDto createDateRangeDto(String type, Date value) {
	    return ApplicationDateRangeDto.builder()
	            .type(type)
	            .value(DateUtil.dateToStringFormat(value))
	            .build();
	}

}
