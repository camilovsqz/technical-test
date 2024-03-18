package com.capitole.technicaltest.infrastructure.inputport.web;



import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.technicaltest.application.constant.LogConstant;
import com.capitole.technicaltest.application.dto.PriceResponseDto;
import com.capitole.technicaltest.application.dto.SearchParamsDto;
import com.capitole.technicaltest.application.service.PriceService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class PriceController.
 */
@RestController
@RequestMapping("/v1/prices")
@Slf4j
@Validated
public class PriceController {
	
	/** The price service. */
	private final PriceService priceService;
	
	
	/**
	 * Instantiates a new price controller.
	 *
	 * @param priceService the price service
	 */
	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}

	/**
	 * Gets the price.
	 *
	 * @param params the params
	 * @return the price
	 */
	@GetMapping
	public ResponseEntity<PriceResponseDto> getPrice(@Valid @ModelAttribute SearchParamsDto params) {
		log.info(LogConstant.NEW_PRICE_SEARCH);
		Optional<PriceResponseDto> priceOptional = priceService.searchPrice(params);
		log.info(LogConstant.SEARCH_FINISHED);
		return priceOptional
				.map(result -> ResponseEntity.ok().body(result)) 
				.orElseGet(() -> ResponseEntity.notFound().build()); 
	}
}
