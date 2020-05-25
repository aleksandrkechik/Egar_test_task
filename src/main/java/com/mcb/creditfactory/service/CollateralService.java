package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.*;
import com.mcb.creditfactory.model.Transport;
import com.mcb.creditfactory.model.Valuation;
import com.mcb.creditfactory.service.transport.AirplaneService;
import com.mcb.creditfactory.service.transport.CarService;
import com.mcb.creditfactory.service.transport.GenericService;
import com.mcb.creditfactory.service.valuations.AirplaneValuationService;
import com.mcb.creditfactory.service.valuations.CarValuationService;
import com.mcb.creditfactory.service.valuations.ValuationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// TODO: reimplement this

/**
 * Reimplemented Collateral service. Now it is able to pick a specific
 * service and adapter for each given transport. To support a new kind of transport, you just need
 * to add a switch case.
 */
@Service
public class CollateralService {
	@Autowired
	private CarService carService;

	@Autowired
	private AirplaneService airplaneService;

	@Autowired
	private CarValuationService carValuationService;

	@Autowired
	private AirplaneValuationService airplaneValuationService;

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
		return Optional.of(dto)
				.map(s::fromDto)
				.map(s::save)
				.map(s::getId)
				.orElse(null);
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

	public Long addValuation (Collateral object)
	{
		if (!(object instanceof ValuationDto)) {
			throw new IllegalArgumentException();
		}
		if (!checkDataExistence(object)) {
			throw new IllegalArgumentException();
		}
		ValuationDto valuation = (ValuationDto)object;
		if (valuation instanceof CarValuationDto) {
			if (!carValuationService.approve((CarValuationDto)valuation))
				return null;
			return add((CarValuationDto) valuation, carValuationService);
		}
		else if (valuation instanceof AirplaneValuationDto) {
			if (!airplaneValuationService.approve((AirplaneValuationDto)valuation))
				return null;
			return add((AirplaneValuationDto) valuation, airplaneValuationService);
		}
		else
			return null;
	}

	public <T extends ValuationDto, E extends Valuation> Long add (T dto, ValuationService<E, T> s) {
		return Optional.of(dto)
				.map(s::fromDto)
				.map(s::save)
				.map(s::getId)
				.orElse(null);
	}


	public boolean checkDataExistence(Collateral object) {
		ValuationDto valuation = (ValuationDto)object;
		if (object instanceof CarValuationDto)
			return carService.getRepository().findById(valuation.transportId).isPresent();
		else
			return airplaneService.getRepository().findById(valuation.transportId).isPresent();
	}
}
