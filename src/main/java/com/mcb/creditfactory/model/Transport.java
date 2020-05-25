package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Abstract class for a transport. In order to implement new transport type
 * you need to make an extending class and corresponding valuation DTO.
 * To add new transports valuations to the valuation table you need to create a specific valuation repository
 * and make your valuation extend an abstract Valuation class.
 */

@Data
@NoArgsConstructor
@MappedSuperclass
@AllArgsConstructor
public abstract class Transport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String brand;
	private String model;
	@Column(name = "year_of_issue")
	private Short year;

	@Column(name = "assessed_value")
	private BigDecimal value;

}
