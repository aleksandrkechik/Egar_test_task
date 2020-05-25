package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.AirplaneValuation;
import com.mcb.creditfactory.model.Valuation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AirplaneValuationsRepository extends CrudRepository<AirplaneValuation, Long> {
	public List<Valuation> getAllByTransportIdEquals(Long transportId);
}
