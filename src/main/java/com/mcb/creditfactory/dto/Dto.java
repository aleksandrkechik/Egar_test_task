package com.mcb.creditfactory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Dto implements Collateral{
	Long id;
	String brand;
	String model;
	Short year;
	BigDecimal value;
}
