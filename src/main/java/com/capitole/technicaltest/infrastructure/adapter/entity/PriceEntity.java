package com.capitole.technicaltest.infrastructure.adapter.entity;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class Price.
 * Reference to the PRICES table that reflects the final price (pvp)
 */
@Entity
@Table(name = "PRICES")
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PriceEntity {
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** The brand id. foreign key from group string */
	@Column(name="BRAND_ID")
	private int brandId;
	
	/** The start date, start date that applies the indicated price rate. */
	@Column(name="START_DATE")
	private Date startDate;
	
	/** The end date, end date that applies the indicated price rate */
	@Column(name="END_DATE")
	private Date endDate;
	
	/** The price list, identifier of the applicable price list. */
	@Column(name="PRICE_LIST")
	private int priceList;
	
	/** The product id, product code identifier */
	@Column(name="PRODUCT_ID")
	private int productId;
	
	/** The priority, pricing application disambiguator. */
	@Column(name="PRIORITY")
	private int priority;
	
	/** The price, final sale price. */
	@Column(name="PRICE")
	private double price;
	
	/** The currency, currency iso */
	@Column(name="CURR")
	private String currency;
}