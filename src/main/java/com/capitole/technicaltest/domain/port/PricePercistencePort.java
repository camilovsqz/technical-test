package com.capitole.technicaltest.domain.port;

import java.util.Date;
import java.util.List;

import com.capitole.technicaltest.domain.model.Price;

/**
 * The Interface PricePercistencePort.
 */
public interface PricePercistencePort {
	
	/**
	 * Find all by aplication date and product id and brand id.
	 *
	 * @param aplicationDate the aplication date
	 * @param productId the product id
	 * @param brandId the brand id
	 * @return the list
	 */
	List<Price> findAllByAplicationDateAndProductIdAndBrandId(Date aplicationDate, int productId, int brandId);
}
