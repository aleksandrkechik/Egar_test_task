package com.mcb.creditfactory.service.valuations;

import com.mcb.creditfactory.dto.AirplaneValuationDto;
import com.mcb.creditfactory.model.AirplaneValuation;
import com.mcb.creditfactory.model.Valuation;
import com.mcb.creditfactory.repository.AirplaneValuationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneValuationService extends ValuationService <AirplaneValuation, AirplaneValuationDto> {

	@Autowired
	private AirplaneValuationsRepository airplaneValuationsRepository;

	@Override
	public CrudRepository<AirplaneValuation, Long> getRepository() {
		return airplaneValuationsRepository;
	}

	@Override
	public List<Valuation> loadAllByTransportId(Long transportId) {
		return airplaneValuationsRepository.getAllByTransportIdEquals(transportId);
	}

	@Override
	public Valuation getLatest(Long transportId) {
		Valuation latest = null;
		for (Valuation valuation : airplaneValuationsRepository.getAllByTransportIdEquals(transportId)) {
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
	public AirplaneValuation fromDto(AirplaneValuationDto dto) {
		return new AirplaneValuation(dto.getId(),
								dto.getTransportId(),
								dto.getValuationDate(),
								dto.getValue());
	}

	@Override
	public AirplaneValuationDto toDTO(AirplaneValuation valuation) {
		return new AirplaneValuationDto(valuation.getId(),
									valuation.getTransportId(),
									valuation.getValuationDate(),
									valuation.getValue());
	}

	@Override
	public boolean approve(AirplaneValuationDto dto) {
		return approveService.approveValuation(new AirplaneValuationAdapter(dto)) == 0;
	}
}
