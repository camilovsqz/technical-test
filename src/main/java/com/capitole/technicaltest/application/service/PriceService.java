package com.capitole.technicaltest.application.service;

import com.capitole.technicaltest.application.dto.PriceResponseDto;
import com.capitole.technicaltest.application.dto.SearchParamsDto;

public interface PriceService {
	PriceResponseDto searchPrice(SearchParamsDto params);
}
