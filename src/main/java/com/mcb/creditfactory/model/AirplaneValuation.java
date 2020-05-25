package com.mcb.creditfactory.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity(name = "AirplaneValuation")
@DiscriminatorValue("AirplaneValuation")
public class AirplaneValuation extends Valuation{

	@Builder
	public AirplaneValuation(long id, long transportId, LocalDate date, BigDecimal value) {
		super (id, transportId, date, value);
	}
}
