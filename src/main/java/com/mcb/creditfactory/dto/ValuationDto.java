package com.mcb.creditfactory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValuationDto implements Collateral{
	public long id;
	public long transportId;
	public LocalDate valuationDate;
	public BigDecimal value;
}
