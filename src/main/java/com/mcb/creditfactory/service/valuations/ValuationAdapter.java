package com.mcb.creditfactory.service.valuations;

import com.mcb.creditfactory.dto.ValuationDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public abstract class ValuationAdapter<T extends ValuationDto> implements CollateralObject{

	abstract T getDto();

	@Override
	public LocalDate getDate() {
		return LocalDate.now();
	}

	@Override
	public abstract CollateralType getType();

	@Override
	public BigDecimal getValue() {return getDto().getValue();}

	@Override
	public Short getYear() {
		return null;
	}




}


