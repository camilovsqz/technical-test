package com.capitole.technicaltest.infrastructure.inputport.web;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.technicaltest.application.dto.PriceResponseDto;
import com.capitole.technicaltest.application.dto.SearchParamsDto;
import com.capitole.technicaltest.application.service.PriceService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/prices")
@Slf4j
@Validated
@RequiredArgsConstructor
public class PriceController {
	private final PriceService priceService;
	@GetMapping
	public ResponseEntity<PriceResponseDto> getPrice(@Valid @ModelAttribute SearchParamsDto params) {
		log.info(params.toString());
		return new ResponseEntity<> (priceService.searchPrice(params), HttpStatus.OK);		
	}
}
