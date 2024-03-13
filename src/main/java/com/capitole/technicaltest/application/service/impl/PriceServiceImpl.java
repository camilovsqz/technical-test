package com.capitole.technicaltest.application.service.impl;

import org.springframework.stereotype.Service;

import com.capitole.technicaltest.application.dto.PriceResponseDto;
import com.capitole.technicaltest.application.dto.SearchParamsDto;
import com.capitole.technicaltest.application.service.PriceService;
import com.capitole.technicaltest.infrastructure.outputadapter.PriceRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PriceServiceImpl implements PriceService {
private final PriceRepository priceRepository;
	
	@Override
	public PriceResponseDto searchPrice(SearchParamsDto params) {
		//TODO: implementar
		return null;
	}
}
