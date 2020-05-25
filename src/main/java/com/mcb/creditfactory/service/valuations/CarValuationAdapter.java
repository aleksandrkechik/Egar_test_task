package com.mcb.creditfactory.service.valuations;

import com.mcb.creditfactory.dto.CarValuationDto;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CarValuationAdapter extends ValuationAdapter<CarValuationDto>{

	CarValuationDto dto;

	@Override
	CarValuationDto getDto() {
		return dto;
	}

	@Override
	public CollateralType getType() {
		return CollateralType.CAR;
	}
}
