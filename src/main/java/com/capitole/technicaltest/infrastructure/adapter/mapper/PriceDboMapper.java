package com.capitole.technicaltest.infrastructure.adapter.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.capitole.technicaltest.domain.model.Price;
import com.capitole.technicaltest.infrastructure.adapter.entity.PriceEntity;

@Mapper(componentModel = "spring")
public interface PriceDboMapper {
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "brandId", target = "brandId")
	@Mapping(source = "startDate", target = "startDate")
	@Mapping(source = "endDate", target = "endDate")
	@Mapping(source = "priceList", target = "priceList")
	@Mapping(source = "productId", target = "productId")
	@Mapping(source = "priority", target = "priority")
	@Mapping(source = "price", target = "price")
	@Mapping(source = "currency", target = "currency")
	PriceEntity toDbo(Price domain);

	@InheritInverseConfiguration
	Price toDomain(PriceEntity entity);
}
