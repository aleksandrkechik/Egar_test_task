package com.mcb.creditfactory.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "AIRPLANE")
public class Airplane extends Transport{

	private int seats;
	private int fuelCapacity;
	private String manufacturer;

	@Builder
	public Airplane(Long id, String brand, String model, Short year, BigDecimal value, int seats, int fuelCapacity, String manufacturer) {
		super(id, brand, model, year, value);
		this.seats = seats;
		this.fuelCapacity = fuelCapacity;
		this.manufacturer = manufacturer;
	}
}
