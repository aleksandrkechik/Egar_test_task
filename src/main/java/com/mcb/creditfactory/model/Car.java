package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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
