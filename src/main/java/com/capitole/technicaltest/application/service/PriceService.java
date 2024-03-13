package com.capitole.technicaltest.application.service;

import java.util.Optional;

import com.capitole.technicaltest.application.dto.PriceResponseDto;
import com.capitole.technicaltest.application.dto.SearchParamsDto;

public interface PriceService {
	Optional<PriceResponseDto> searchPrice(SearchParamsDto params);
}
