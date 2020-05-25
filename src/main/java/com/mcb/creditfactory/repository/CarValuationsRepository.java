package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.CarValuation;
import com.mcb.creditfactory.model.Valuation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarValuationsRepository extends CrudRepository<CarValuation, Long> {
	public List<Valuation> getAllByTransportIdEquals(Long transportId);
}
