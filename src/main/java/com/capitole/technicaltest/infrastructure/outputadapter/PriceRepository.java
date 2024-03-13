package com.capitole.technicaltest.infrastructure.outputadapter;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capitole.technicaltest.domain.model.Price;

public interface PriceRepository extends JpaRepository<Price, Integer> {
	List<Price> findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandId(Date aplicationDate1,
			Date aplicationDate2,
			int productId,
			int brandId);
}
