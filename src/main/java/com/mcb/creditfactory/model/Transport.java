package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

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
