package com.capitole.technicaltest.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BRANDS")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
	@Id
	private String id;
	
	private String name;
}
