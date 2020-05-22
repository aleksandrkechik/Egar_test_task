package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface AirplaneRepository extends CrudRepository<Airplane, Long> {
}
