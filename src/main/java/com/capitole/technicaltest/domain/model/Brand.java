package com.capitole.technicaltest.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
/**
 * The Class Brand.
 * Reference to the Brand domain
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
	/** The id. */
	private String id;
	
	/** The brand. */
	private String name;
}
