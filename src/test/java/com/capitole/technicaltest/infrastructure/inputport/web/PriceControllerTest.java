package com.capitole.technicaltest.infrastructure.inputport.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capitole.technicaltest.application.service.PriceService;
import com.capitole.technicaltest.application.service.impl.PriceServiceImpl;
import com.capitole.technicaltest.domain.model.Price;
import com.capitole.technicaltest.domain.port.PricePercistencePort;

public class PriceControllerTest {

	private PriceController priceController;
	private MockMvc mockMvc;

	@BeforeEach
	public void init() {
		PriceService priceService = new PriceServiceImpl(new PricePercistencePortMock());
        priceController = new PriceController(priceService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(priceController).build();
	}

	@Test
	public void ifSearchPrice_thenReturnHttp200() throws Exception {
		this.mockMvc.perform(get("/v1/prices?applicationDate=2020-06-14 18:30:00&productIdentifier=35455&brandIdentifier=1")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
	}

	@Test
	public void ifSearchPrice_thenReturnHttp400() throws Exception {
		this.mockMvc.perform(get("/v1/prices?applicationDate=2020-06-14 18:30:00&productIdentifier=35455")
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest());
	}

	@Test
	public void ifSearchPrice_thenReturnHttp404() throws Exception {
		PriceService priceService = new PriceServiceImpl(new EmptyPricePercistencePortMock());
        priceController = new PriceController(priceService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(priceController).build();
		this.mockMvc.perform(get("/v1/prices?applicationDate=2020-06-14 18:30:00&productIdentifier=35455&brandIdentifier=1")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound());
	}
	
	private static class PricePercistencePortMock implements PricePercistencePort {
        @Override
        public List<Price> findAllByAplicationDateAndProductIdAndBrandId(Date applicationDate, int productId, int brandId) {
            return new ArrayList<>(Arrays.asList(
                    new Price(1, 1, new Date(1592107200L), new Date(1609469999L), 1, 35455, 0, 35.50, "EUR")));
        }
    }
	
	private static class EmptyPricePercistencePortMock implements PricePercistencePort {
        @Override
        public List<Price> findAllByAplicationDateAndProductIdAndBrandId(Date applicationDate, int productId, int brandId) {
            return new ArrayList<>();
        }
    }
}
