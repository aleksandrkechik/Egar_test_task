package com.mcb.creditfactory.service.transport;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AirplaneService extends GenericService<Airplane, AirplaneDto>{

	@Autowired
	private AirplaneRepository airplaneRepository;

	@Override
	public CrudRepository<Airplane, Long> getRepository() {
		return airplaneRepository;
	}

	@Override
	public Airplane fromDto(AirplaneDto dto) {
		return new Airplane(
				dto.getId(),
				dto.getBrand(),
				dto.getModel(),
				dto.getYear(),
				dto.getValue(),
				dto.getSeats(),
				dto.getFuelCapacity(),
				dto.getManufacturer()
		);
	}

	@Override
	public AirplaneDto toDTO(Airplane transport) {
		return new AirplaneDto(
				transport.getId(),
				transport.getBrand(),
				transport.getModel(),
				transport.getYear(),
				transport.getValue(),
				transport.getSeats(),
				transport.getFuelCapacity(),
				transport.getManufacturer()
		);
	}


	@Override
	public boolean approve(AirplaneDto dto) {
		return approveService.approve(new AirplaneAdapter(dto)) == 0;
	}
}
