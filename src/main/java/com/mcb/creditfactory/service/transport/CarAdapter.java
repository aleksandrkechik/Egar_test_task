package com.mcb.creditfactory.service.transport;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

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

	@Override
	public LocalDate getDate() {
		return LocalDate.now();
	}
}
