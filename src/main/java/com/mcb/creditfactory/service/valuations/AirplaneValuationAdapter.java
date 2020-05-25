package com.mcb.creditfactory.service.valuations;

import com.mcb.creditfactory.dto.AirplaneValuationDto;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AirplaneValuationAdapter extends ValuationAdapter<AirplaneValuationDto>{

	AirplaneValuationDto dto;

	@Override
	AirplaneValuationDto getDto() {
		return dto;
	}

	@Override
	public CollateralType getType() {
		return CollateralType.AIRPLANE;
	}
}
