package com.mcb.creditfactory.service.valuations;

import com.mcb.creditfactory.dto.ValuationDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Valuation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Generic service for both Airplane and Car valuations.
 * (And any transport to be added)
 * I've also implemented methods for loading all the valuations
 * for given transport(by it's ID) - loadAllByTransportId
 * Another yet unused method is getLatest, it'd be used for getting the latest transport's evaluation.
 */
@Service
public abstract class ValuationService <T extends Valuation, E extends ValuationDto>{

	@Autowired
	ExternalApproveService approveService;


	public abstract CrudRepository<T, Long> getRepository();

	public T save(T valuations) {
		return getRepository().save(valuations);
	}

	public abstract List<Valuation> loadAllByTransportId(Long transportId);

	public abstract Valuation getLatest(Long transportId);

	public abstract T fromDto(E dto);

	public abstract E toDTO(T valuation);

	public Long getId(T valuation) {return valuation.getId();}

	public abstract boolean approve(E dto);

}
