package com.capitole.technicaltest.application.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capitole.technicaltest.application.dto.PriceResponseDto;
import com.capitole.technicaltest.application.dto.SearchParamsDto;
import com.capitole.technicaltest.domain.model.Price;
import com.capitole.technicaltest.domain.port.PricePercistencePort;

public class PriceServiceImplTest {

	@Test
	public void ifSearchPrice_thenReturnPrices() {
		PricePercistencePort pricePercistencePort = new PricePercistencePortMock();
        PriceServiceImpl priceServiceImpl = new PriceServiceImpl(pricePercistencePort);
		
		SearchParamsDto searchParamsDto = new SearchParamsDto();
		searchParamsDto.setApplicationDate(new Date(1592173800L));
		searchParamsDto.setBrandIdentifier(1);
		searchParamsDto.setProductIdentifier(35455);
		
		Optional<PriceResponseDto> price = priceServiceImpl.searchPrice(searchParamsDto);
		
		Assertions.assertTrue(price.isPresent());
		Assertions.assertEquals(price.get().getProductId(), 35455);
		Assertions.assertEquals(price.get().getFinalPrice(), 25.45);

	}

	@Test
	public void ifSearchPrice_thenReturnOptionalEmpty() {
		PricePercistencePort pricePercistencePort = new EmptyPricePercistencePortMock();
        PriceServiceImpl priceServiceImpl = new PriceServiceImpl(pricePercistencePort);
        
		SearchParamsDto searchParamsDto = new SearchParamsDto();
		searchParamsDto.setApplicationDate(new Date(1592173800L));
		searchParamsDto.setBrandIdentifier(1);
		searchParamsDto.setProductIdentifier(35455);
		
		Optional<PriceResponseDto> price = priceServiceImpl.searchPrice(searchParamsDto);
		
		Assertions.assertTrue(price.isEmpty());
	}
	
	private static class PricePercistencePortMock implements PricePercistencePort {
        @Override
        public List<Price> findAllByAplicationDateAndProductIdAndBrandId(Date applicationDate, int productId, int brandId) {
            return new ArrayList<>(Arrays.asList(
                    new Price(1, 1, new Date(1592107200L), new Date(1609469999L), 1, 35455, 0, 35.50, "EUR"),
                    new Price(2, 1, new Date(1592161200L), new Date(1592173800L), 2, 35455, 1, 25.45, "EUR")));
        }
    }
	
	private static class EmptyPricePercistencePortMock implements PricePercistencePort {
        @Override
        public List<Price> findAllByAplicationDateAndProductIdAndBrandId(Date applicationDate, int productId, int brandId) {
            return new ArrayList<>();
        }
    }

}
