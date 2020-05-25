package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@JsonTypeName("carValue")
public class CarValuationDto extends ValuationDto{

	@Builder
	public CarValuationDto (long id, long transportId, LocalDate valuationDate, BigDecimal value) {
		super(id, transportId, valuationDate, value);
	}
}
