package com.capitole.technicaltest.domain.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
/**
 * The Class Price.
 * Reference to the PRICES domain
 */
@Getter
@Builder
@AllArgsConstructor
public class Price {
	/** The id. */
	private Integer id;
	
	/** The brand id. foreign key from group string */
	private int brandId;
	
	/** The start date, start date that applies the indicated price rate. */
	private Date startDate;
	
	/** The end date, end date that applies the indicated price rate */
	private Date endDate;
	
	/** The price list, identifier of the applicable price list. */
	private int priceList;
	
	/** The product id, product code identifier */
	private int productId;
	
	/** The priority, pricing application disambiguator. */
	private int priority;
	
	/** The price, final sale price. */
	private double price;
	
	/** The currency, currency iso */
	private String currency;
}
