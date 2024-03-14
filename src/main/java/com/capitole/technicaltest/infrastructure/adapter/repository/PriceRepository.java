package com.capitole.technicaltest.infrastructure.adapter.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capitole.technicaltest.infrastructure.adapter.entity.PriceEntity;

/**
 * The Interface PriceRepository.
 */
public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {
	
	/**
	 * Find all by start date less than equal and end date greater than equal and product id and brand id.
	 *
	 * @param aplicationDate1 the aplication date 1
	 * @param aplicationDate2 the aplication date 2
	 * @param productId the product id
	 * @param brandId the brand id
	 * @return the list
	 */
	List<PriceEntity> findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandId(
			Date aplicationDate1, Date aplicationDate2, int productId, int brandId);
}
