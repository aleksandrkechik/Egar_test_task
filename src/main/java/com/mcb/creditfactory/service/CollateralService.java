package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.dto.Dto;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.model.Transport;
import com.mcb.creditfactory.service.transport.AirplaneService;
import com.mcb.creditfactory.service.transport.CarService;
import com.mcb.creditfactory.service.transport.GenericAdapter;
import com.mcb.creditfactory.service.transport.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

// TODO: reimplement this
@Service
public class CollateralService {
	@Autowired
	private CarService carService;

	@Autowired
	private AirplaneService airplaneService;

	@SuppressWarnings("ConstantConditions")
	public Long saveCollateral(Collateral object) {
		if (!(object instanceof Dto)) {
			throw new IllegalArgumentException();
		}

		Dto dto = (Dto) object;
		if (dto instanceof CarDto) {
			if (!carService.approve((CarDto)dto))
				return null;
			return saveCollateral((CarDto) dto, carService);
		}
		else if (dto instanceof AirplaneDto) {
			if (!airplaneService.approve((AirplaneDto)dto))
				return null;
			return saveCollateral((AirplaneDto) dto, airplaneService);
		}
		else
			return null;
	}

	private <T extends Dto, E extends Transport> Long saveCollateral(T dto, GenericService<E, T> s) {
//		return Optional.of(dto)
//				.map(s::fromDto)
//				.map(s::save)
//				.map(s::getId)
//				.orElse(null);

		Optional<T> temp1 = Optional.of(dto);
		Optional<E> temp2 = temp1.map(s::fromDto);
		Optional<E> temp3 = temp2.map(s::save);
		Optional<Long> temp4 = temp3.map(s::getId);
		return temp4.orElse(null);
/*		return Optional.of(dto)
				.map(s::fromDto)
				.map(s::save)
				.map(s::getId)
				.orElse(null);*/
	}

	public Collateral getInfo(Collateral object) {
		if (!(object instanceof Dto)) {
			throw new IllegalArgumentException();
		}
		Dto dto = (Dto) object;
		if (dto instanceof CarDto) {
			if (!carService.approve((CarDto)dto))
				return null;
			return loadCollateral((CarDto) dto, carService);
		}
		else if (dto instanceof AirplaneDto) {
			if (!airplaneService.approve((AirplaneDto)dto))
				return null;
			return loadCollateral((AirplaneDto) dto, airplaneService);
		}
		else
			return null;
	}

	private <T extends Dto, E extends Transport> Collateral loadCollateral(T dto, GenericService<E, T> s) {

		return Optional.of(dto)
				.map(s::fromDto)
				.map(s::getId)
				.flatMap(s::load)
				.map(s::toDTO)
				.orElse(null);
	}
}
