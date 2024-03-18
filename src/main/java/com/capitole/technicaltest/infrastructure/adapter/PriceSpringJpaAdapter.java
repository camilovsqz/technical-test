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

/**
 * The Class PriceSpringJpaAdapter. JPA Adapter interact with the Price entity
 */
@Service
@Transactional
public class PriceSpringJpaAdapter implements PricePercistencePort {

	/** The price dbo mapper. */
	private final PriceDboMapper priceDboMapper;

	/** The price repository. */
	private final PriceRepository priceRepository;

	/**
	 * Instantiates a new price spring jpa adapter.
	 *
	 * @param priceDboMapper  the price dbo mapper
	 * @param priceRepository the price repository
	 */
	public PriceSpringJpaAdapter(PriceDboMapper priceDboMapper, PriceRepository priceRepository) {
		this.priceDboMapper = priceDboMapper;
		this.priceRepository = priceRepository;
	}

	/**
	 * Find all by aplication date and product id and brand id.
	 *
	 * @param accurrencyDate the accurrency date
	 * @param productId      the product id
	 * @param brandId        the brand id
	 * @return the list
	 */
	@Override
	public List<Price> findAllByAplicationDateAndProductIdAndBrandId(Date accurrencyDate, int productId, int brandId) {
		List<PriceEntity> priceList = priceRepository
				.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandId(accurrencyDate,
						accurrencyDate, productId, brandId);
		return priceList.stream().map(priceDboMapper::toDomain).collect(Collectors.toList());
	}
}
