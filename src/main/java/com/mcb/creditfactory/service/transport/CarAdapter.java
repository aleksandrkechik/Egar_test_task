package com.mcb.creditfactory.service.transport;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Car;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class CarAdapter extends GenericAdapter<CarDto> {

	CarDto dto;

	@Override
	CarDto getDto() {
		return dto;
	}

	@Override
	public BigDecimal getValue() {
		return dto.getValue();
	}

	@Override
	public CollateralType getType() {
		return CollateralType.CAR;
	}
}
