package com.mcb.creditfactory.service.transport;

import com.mcb.creditfactory.dto.Dto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public abstract class GenericAdapter<T extends Dto> implements CollateralObject{

	abstract T getDto();

	@Override
	public Short getYear() {
		return getDto().getYear();
	}

	@Override
	public LocalDate getDate() {
		return LocalDate.now();
	}

	@Override
	public abstract CollateralType getType();

	@Override
	public BigDecimal getValue() {return getDto().getValue();}



}


