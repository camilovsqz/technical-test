package com.capitole.technicaltest.infrastructure.adapter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.capitole.technicaltest.domain.model.Price;
import com.capitole.technicaltest.domain.port.PricePercistencePort;
import com.capitole.technicaltest.infrastructure.adapter.entity.PriceEntity;
import com.capitole.technicaltest.infrastructure.adapter.mapper.PriceDboMapper;
import com.capitole.technicaltest.infrastructure.adapter.repository.PriceRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PriceSpringJpaAdapter implements PricePercistencePort {
	private final PriceDboMapper priceDboMapper;
	private final PriceRepository priceRepository;

	@Override
	public List<Price> findAllByAplicationDateAndProductIdAndBrandId(Date accurrencyDate, int productId, int brandId) {
		List<PriceEntity> priceList = priceRepository.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandId(
				accurrencyDate,
				accurrencyDate,
				productId,
				brandId);
		return priceList.stream()
                .map(priceDboMapper::toDomain)
                .collect(Collectors.toList());
	}
}
