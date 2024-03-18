package com.capitole.technicaltest.infrastructure.inputport.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import com.capitole.technicaltest.TechnicalTestApplication;
import com.capitole.technicaltest.application.constant.AppConstant;
import com.capitole.technicaltest.application.dto.ApplicationDateRangeDto;
import com.capitole.technicaltest.application.dto.PriceResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = { TechnicalTestApplication.class })
public class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	// Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1
	// (ZARA)
	@Test
	void ifRequestTest1_ReturnOK() throws Exception {
		/*
		 * expected response
		 * 
		 * { "productId": 35455, "brandId": 1, "rateToApply": 1,
		 * "applicationDateRange": [ { "type": "start", "value":
		 * "2020-06-14 00:00:00" }, { "type": "end", "value": "2020-12-31 23:59:59" } ],
		 * "finalPrice": 35.5 }
		 * 
		 * 
		 */
		String url = "http://localhost:" + port + "/"
				+ "/v1/prices?applicationDate=2020-06-14 10:00:00&productIdentifier=35455&brandIdentifier=1";
		String jsonResponse = this.restTemplate.getForObject(url, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		PriceResponseDto priceResponseDto = objectMapper.readValue(jsonResponse, PriceResponseDto.class);
		ApplicationDateRangeDto startDateResponse = priceResponseDto.getApplicationDateRange().stream()
				.filter(x -> x.getType().equals(AppConstant.START_DATE)).findFirst().get();
		ApplicationDateRangeDto endDateResponse = priceResponseDto.getApplicationDateRange().stream()
				.filter(x -> x.getType().equals(AppConstant.END_DATE)).findFirst().get();

		Assertions.assertNotNull(jsonResponse);
		Assertions.assertNotNull(priceResponseDto);
		Assertions.assertEquals(35455, priceResponseDto.getProductId());
		Assertions.assertEquals(1, priceResponseDto.getBrandId());
		Assertions.assertEquals(1, priceResponseDto.getRateToApply());
		Assertions.assertEquals(35.5, priceResponseDto.getFinalPrice());
		Assertions.assertEquals("2020-06-14 00:00:00", startDateResponse.getValue());
		Assertions.assertEquals("2020-12-31 23:59:59", endDateResponse.getValue());

	}

	// Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1
	// (ZARA)
	@Test
	void ifRequestTest2_ReturnOK() throws Exception {
		/*
		 * expected response
		 * 
		 * { "productId": 35455, "brandId": 1, "rateToApply": 2,
		 * "applicationDateRange": [ { "type": "start", "value":
		 * "2020-06-14 15:00:00" }, { "type": "end", "value": "2020-06-14 18:30:00" } ],
		 * "finalPrice": 25.45 }
		 * 
		 */
		String url = "http://localhost:" + port + "/"
				+ "/v1/prices?applicationDate=2020-06-14 16:00:00&productIdentifier=35455&brandIdentifier=1";
		String jsonResponse = this.restTemplate.getForObject(url, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		PriceResponseDto priceResponseDto = objectMapper.readValue(jsonResponse, PriceResponseDto.class);
		ApplicationDateRangeDto startDateResponse = priceResponseDto.getApplicationDateRange().stream()
				.filter(x -> x.getType().equals(AppConstant.START_DATE)).findFirst().get();
		ApplicationDateRangeDto endDateResponse = priceResponseDto.getApplicationDateRange().stream()
				.filter(x -> x.getType().equals(AppConstant.END_DATE)).findFirst().get();

		Assertions.assertNotNull(jsonResponse);
		Assertions.assertNotNull(priceResponseDto);
		Assertions.assertEquals(35455, priceResponseDto.getProductId());
		Assertions.assertEquals(1, priceResponseDto.getBrandId());
		Assertions.assertEquals(2, priceResponseDto.getRateToApply());
		Assertions.assertEquals(25.45, priceResponseDto.getFinalPrice());
		Assertions.assertEquals("2020-06-14 15:00:00", startDateResponse.getValue());
		Assertions.assertEquals("2020-06-14 18:30:00", endDateResponse.getValue());

	}

	// Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1
	// (ZARA)
	@Test
	void ifRequestTest3_ReturnOK() throws Exception {
		/*
		 * expected response
		 * 
		 * { "productId": 35455, "brandId": 1, "rateToApply": 1,
		 * "applicationDateRange": [ { "type": "start", "value":
		 * "2020-06-14 00:00:00" }, { "type": "end", "value": "2020-12-31 23:59:59" } ],
		 * "finalPrice": 35.5 }
		 * 
		 * 
		 */
		String url = "http://localhost:" + port + "/"
				+ "/v1/prices?applicationDate=2020-06-14 21:00:00&productIdentifier=35455&brandIdentifier=1";
		String jsonResponse = this.restTemplate.getForObject(url, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		PriceResponseDto priceResponseDto = objectMapper.readValue(jsonResponse, PriceResponseDto.class);
		ApplicationDateRangeDto startDateResponse = priceResponseDto.getApplicationDateRange().stream()
				.filter(x -> x.getType().equals(AppConstant.START_DATE)).findFirst().get();
		ApplicationDateRangeDto endDateResponse = priceResponseDto.getApplicationDateRange().stream()
				.filter(x -> x.getType().equals(AppConstant.END_DATE)).findFirst().get();

		Assertions.assertNotNull(jsonResponse);
		Assertions.assertNotNull(priceResponseDto);
		Assertions.assertEquals(35455, priceResponseDto.getProductId());
		Assertions.assertEquals(1, priceResponseDto.getBrandId());
		Assertions.assertEquals(1, priceResponseDto.getRateToApply());
		Assertions.assertEquals(35.5, priceResponseDto.getFinalPrice());
		Assertions.assertEquals("2020-06-14 00:00:00", startDateResponse.getValue());
		Assertions.assertEquals("2020-12-31 23:59:59", endDateResponse.getValue());

	}

	// Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1
	// (ZARA)
	@Test
	void ifRequestTest4_ReturnOK() throws Exception {
		/*
		 * expected response
		 * 
		 * { "productId": 35455, "brandId": 1, "rateToApply": 3,
		 * "applicationDateRange": [ { "type": "start", "value":
		 * "2020-06-15 00:00:00" }, { "type": "end", "value": "2020-06-15 11:00:00" } ],
		 * "finalPrice": 30.5 }
		 * 
		 * 
		 */
		String url = "http://localhost:" + port + "/"
				+ "/v1/prices?applicationDate=2020-06-15 10:00:00&productIdentifier=35455&brandIdentifier=1";
		String jsonResponse = this.restTemplate.getForObject(url, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		PriceResponseDto priceResponseDto = objectMapper.readValue(jsonResponse, PriceResponseDto.class);
		ApplicationDateRangeDto startDateResponse = priceResponseDto.getApplicationDateRange().stream()
				.filter(x -> x.getType().equals(AppConstant.START_DATE)).findFirst().get();
		ApplicationDateRangeDto endDateResponse = priceResponseDto.getApplicationDateRange().stream()
				.filter(x -> x.getType().equals(AppConstant.END_DATE)).findFirst().get();

		Assertions.assertNotNull(jsonResponse);
		Assertions.assertNotNull(priceResponseDto);
		Assertions.assertEquals(35455, priceResponseDto.getProductId());
		Assertions.assertEquals(1, priceResponseDto.getBrandId());
		Assertions.assertEquals(3, priceResponseDto.getRateToApply());
		Assertions.assertEquals(30.5, priceResponseDto.getFinalPrice());
		Assertions.assertEquals("2020-06-15 00:00:00", startDateResponse.getValue());
		Assertions.assertEquals("2020-06-15 11:00:00", endDateResponse.getValue());

	}

	// Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1
	// (ZARA)
	@Test
	void ifRequestTest5_ReturnOK() throws Exception {
		/*
		 * expected response
		 * 
		 * { "productId": 35455, "brandId": 1, "rateToApply": 4,
		 * "applicationDateRange": [ { "type": "start", "value":
		 * "2020-06-15 16:00:00" }, { "type": "end", "value": "2020-12-31 23:59:59" } ],
		 * "finalPrice": 38.95 }
		 * 
		 * 
		 */
		String url = "http://localhost:" + port + "/"
				+ "/v1/prices?applicationDate=2020-06-16 21:00:00&productIdentifier=35455&brandIdentifier=1";
		String jsonResponse = this.restTemplate.getForObject(url, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		PriceResponseDto priceResponseDto = objectMapper.readValue(jsonResponse, PriceResponseDto.class);
		ApplicationDateRangeDto startDateResponse = priceResponseDto.getApplicationDateRange().stream()
				.filter(x -> x.getType().equals(AppConstant.START_DATE)).findFirst().get();
		ApplicationDateRangeDto endDateResponse = priceResponseDto.getApplicationDateRange().stream()
				.filter(x -> x.getType().equals(AppConstant.END_DATE)).findFirst().get();

		Assertions.assertNotNull(jsonResponse);
		Assertions.assertNotNull(priceResponseDto);
		Assertions.assertEquals(35455, priceResponseDto.getProductId());
		Assertions.assertEquals(1, priceResponseDto.getBrandId());
		Assertions.assertEquals(4, priceResponseDto.getRateToApply());
		Assertions.assertEquals(38.95, priceResponseDto.getFinalPrice());
		Assertions.assertEquals("2020-06-15 16:00:00", startDateResponse.getValue());
		Assertions.assertEquals("2020-12-31 23:59:59", endDateResponse.getValue());

	}

}
