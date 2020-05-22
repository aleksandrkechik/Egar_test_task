package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mcb.creditfactory.model.Airplane;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@JsonTypeName("airplane")
public class AirplaneDto extends Dto{

	int seats;
	int fuelCapacity;
	private String manufacturer;

	@Builder
	public AirplaneDto(Long id, String brand, String model, Short year, BigDecimal value, int seats, int fuelCapacity, String manufacturer) {
		super(id, brand, model, year, value);
		this.seats = seats;
		this.fuelCapacity = fuelCapacity;
		this.manufacturer = manufacturer;
	}
}
