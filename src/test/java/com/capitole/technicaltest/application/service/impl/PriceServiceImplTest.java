package com.capitole.technicaltest.application.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capitole.technicaltest.application.dto.PriceResponseDto;
import com.capitole.technicaltest.application.dto.SearchParamsDto;
import com.capitole.technicaltest.domain.model.Price;
import com.capitole.technicaltest.domain.port.PricePercistencePort;

@ExtendWith({ MockitoExtension.class, SpringExtension.class })
public class PriceServiceImplTest {
	@InjectMocks
	private PriceServiceImpl priceServiceImpl;

	@Mock
	private PricePercistencePort pricePercistencePort;

	@Test
	public void ifSearchPrice_ReturnPrices() {
		SearchParamsDto searchParamsDto = new SearchParamsDto();
		searchParamsDto.setApplicationDate(new Date(1592173800L));
		searchParamsDto.setBrandIdentifier(1);
		searchParamsDto.setProductIdentifier(35455);
		Mockito.when(
				pricePercistencePort.findAllByAplicationDateAndProductIdAndBrandId(searchParamsDto.getApplicationDate(),
						searchParamsDto.getProductIdentifier(), searchParamsDto.getBrandIdentifier()))
				.thenReturn(new ArrayList<>(Arrays.asList(
						new Price(1, 1, new Date(1592107200L), new Date(1609469999L), 1, 35455, 0, 35.50, "EUR"),
						new Price(2, 1, new Date(1592161200L), new Date(1592173800L), 2, 35455, 1, 25.45, "EUR"))));
		Optional<PriceResponseDto> price = priceServiceImpl.searchPrice(searchParamsDto);
		Assertions.assertTrue(price.isPresent());
		Assertions.assertEquals(price.get().getProductId(), 35455);
		Assertions.assertEquals(price.get().getFinalPrice(), 25.45);

	}

	@Test
	public void ifSearchPrice_ReturnOptionalEmpty() {
		SearchParamsDto searchParamsDto = new SearchParamsDto();
		searchParamsDto.setApplicationDate(new Date(1592173800L));
		searchParamsDto.setBrandIdentifier(1);
		searchParamsDto.setProductIdentifier(35455);
		Mockito.when(
				pricePercistencePort.findAllByAplicationDateAndProductIdAndBrandId(searchParamsDto.getApplicationDate(),
						searchParamsDto.getProductIdentifier(), searchParamsDto.getBrandIdentifier())).thenReturn(new ArrayList<>());
		Optional<PriceResponseDto> price = priceServiceImpl.searchPrice(searchParamsDto);
		Assertions.assertTrue(price.isEmpty());
	}

}
