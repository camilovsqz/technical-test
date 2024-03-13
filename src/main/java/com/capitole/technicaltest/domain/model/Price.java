package com.capitole.technicaltest.domain.model;

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

@Entity
@Table(name = "PRICES")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="BRAND_ID")
	private int brandId;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="END_DATE")
	private Date endDate;
	
	@Column(name="PRICE_LIST")
	private int priceList;
	
	@Column(name="PRODUCT_ID")
	private int productId;
	
	@Column(name="PRIORITY")
	private int priority;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="CURR")
	private String currency;
}
