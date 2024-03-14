package com.capitole.technicaltest.application.service;

import java.util.Optional;

import com.capitole.technicaltest.application.dto.PriceResponseDto;
import com.capitole.technicaltest.application.dto.SearchParamsDto;

/**
 * The Interface PriceService.
 */
public interface PriceService {
	
	/**
	 * Search price.
	 *
	 * @param params the params
	 * @return the optional
	 */
	Optional<PriceResponseDto> searchPrice(SearchParamsDto params);
}
