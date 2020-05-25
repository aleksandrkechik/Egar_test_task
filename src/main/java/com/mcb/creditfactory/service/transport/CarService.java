package com.mcb.creditfactory.service.transport;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService extends GenericService<Car, CarDto>{

	@Autowired
	private CarRepository carRepository;

	@Override
	public CrudRepository<Car, Long> getRepository() {
		return carRepository;
	}

	@Override
	public boolean approve(CarDto dto) {
		return approveService.approve(new CarAdapter(dto)) == 0;
	}

	@Override
	public Car fromDto(CarDto dto) {
		return new Car(
				dto.getId(),
				dto.getBrand(),
				dto.getModel(),
				dto.getYear(),
				dto.getPower(),
				dto.getValue()
		);
	}

	@Override
	public CarDto toDTO(Car car) {
		return new CarDto(
				car.getId(),
				car.getBrand(),
				car.getModel(),
				car.getYear(),
				car.getPower(),
				car.getValue()
		);
	}
}
