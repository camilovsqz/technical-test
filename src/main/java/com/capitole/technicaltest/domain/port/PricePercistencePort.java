package com.capitole.technicaltest.domain.port;

import java.util.Date;
import java.util.List;

import com.capitole.technicaltest.domain.model.Price;

public interface PricePercistencePort {
	List<Price> findAllByAplicationDateAndProductIdAndBrandId(Date aplicationDate, int productId, int brandId);
}
