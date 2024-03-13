package com.capitole.technicaltest.infrastructure.adapter.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The Class Brand.
 * Reference to the Brands table, group brands.
 */
@Entity
@Table(name = "BRANDS")
@Getter
@NoArgsConstructor
public class BrandEntity {
	/** The id. */
	@Id
	private String id;
	
	/** The brand. */
	private String name;
}