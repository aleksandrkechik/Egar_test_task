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
//@AllArgsConstructor
@Entity(name = "CarValuation")
@DiscriminatorValue("CarValuation")
public class CarValuation extends Valuation{


	@Builder
	public CarValuation(long id, long transportId, LocalDate date, BigDecimal value) {
		super (id, transportId, date, value);
	}
}
