package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@JsonTypeName("car")
public class CarDto extends Dto{
    private Double power;

    @Builder
    public CarDto(Long id, String brand, String model, Short year, Double power, BigDecimal value) {
        super(id, brand, model, year, value);
        this.power = power;

    }
}
