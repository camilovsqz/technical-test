package com.capitole.technicaltest.infrastructure.adapter.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capitole.technicaltest.infrastructure.adapter.entity.PriceEntity;

public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {
	List<PriceEntity> findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandId(
			Date aplicationDate1, Date aplicationDate2, int productId, int brandId);
}
