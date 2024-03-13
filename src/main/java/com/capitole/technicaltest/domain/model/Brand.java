package com.capitole.technicaltest.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
/**
 * The Class Brand.
 * Reference to the Brands table, group brands.
 */
@Entity
@Table(name = "BRANDS")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
	/** The id. */
	@Id
	private String id;
	
	/** The brand name. */
	private String name;
}
