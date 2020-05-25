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
@Table(name = "CAR")
public class Car extends Transport {
    private Double power;


    @Builder
    public Car(Long id, String brand, String model, Short year, Double power, BigDecimal value) {
        super(id, brand, model, year, value);
        this.power = power;
    }
}
