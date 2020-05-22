package com.mcb.creditfactory.service.transport;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Airplane;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class AirplaneAdapter extends GenericAdapter<AirplaneDto> {

	AirplaneDto dto;

	@Override
	AirplaneDto getDto() {
		return dto;
	}


	@Override
	public BigDecimal getValue() {
		return dto.getValue();
	}

	@Override
	public CollateralType getType() {
		return CollateralType.AIRPLANE;
	}

	public int getSeats(){ return dto.getSeats();}

	public int getFuelCapacity(){ return dto.getFuelCapacity();}
}
