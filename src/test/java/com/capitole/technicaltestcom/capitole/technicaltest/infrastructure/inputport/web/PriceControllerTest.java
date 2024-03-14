package com.capitole.technicaltestcom.capitole.technicaltest.infrastructure.inputport.web;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capitole.technicaltest.application.dto.PriceResponseDto;
import com.capitole.technicaltest.application.service.PriceService;
import com.capitole.technicaltest.infrastructure.inputport.web.PriceController;

public class PriceControllerTest {

	@InjectMocks
	private PriceController priceController;

	@Mock
	private PriceService priceService;

	private MockMvc mockMvc;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(priceController).build();
	}

	@Test
	public void ifSearchPrice_ReturnHttp200() throws Exception {
		Mockito.when(priceService.searchPrice(any())).thenReturn(Optional.ofNullable(new PriceResponseDto()));
		this.mockMvc
				.perform(get("/v1/prices?applicationDate=2020-06-14 18:30:00&productIdentifier=35455&brandIdentifier=1")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}

	@Test
	public void ifSearchPrice_ReturnHttp400() throws Exception {
		Mockito.when(priceService.searchPrice(any())).thenReturn(Optional.ofNullable(new PriceResponseDto()));
		this.mockMvc.perform(get("/v1/prices?applicationDate=2020-06-14 18:30:00&productIdentifier=35455")
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest());
	}

	@Test
	public void ifSearchPrice_ReturnHttp404() throws Exception {
		Mockito.when(priceService.searchPrice(any())).thenReturn(Optional.empty());
		this.mockMvc
				.perform(get("/v1/prices?applicationDate=2020-06-14 18:30:00&productIdentifier=35455&brandIdentifier=1")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isNotFound());
	}
}
