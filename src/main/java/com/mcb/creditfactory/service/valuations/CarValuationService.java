package com.mcb.creditfactory.service.valuations;

import com.mcb.creditfactory.dto.CarValuationDto;
import com.mcb.creditfactory.model.CarValuation;
import com.mcb.creditfactory.model.Valuation;
import com.mcb.creditfactory.repository.CarValuationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarValuationService extends ValuationService <CarValuation, CarValuationDto> {

	@Autowired
	private CarValuationsRepository carValuationsRepository;

	@Override
	public CrudRepository<CarValuation, Long> getRepository() {
		return carValuationsRepository;
	}

	@Override
	public List<Valuation> loadAllByTransportId(Long transportId) {
		return carValuationsRepository.getAllByTransportIdEquals(transportId);
	}

	@Override
	public Valuation getLatest(Long transportId) {
		Valuation latest = null;
		for (Valuation valuation : carValuationsRepository.getAllByTransportIdEquals(transportId)) {
			if (latest == null)
				latest = valuation;
			else
			{
				if (latest.getValuationDate().isBefore(valuation.getValuationDate()))
					latest = valuation;
			}
		}
		return(latest);
	}


	@Override
	public CarValuation fromDto(CarValuationDto dto) {
		return new CarValuation(dto.getId(),
								dto.getTransportId(),
								dto.getValuationDate(),
								dto.getValue());
	}

	@Override
	public CarValuationDto toDTO(CarValuation valuation) {
		return new CarValuationDto(valuation.getId(),
									valuation.getTransportId(),
									valuation.getValuationDate(),
									valuation.getValue());
	}

	@Override
	public boolean approve(CarValuationDto dto) {
		return approveService.approveValuation(new CarValuationAdapter(dto)) == 0;
	}
}
