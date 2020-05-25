package com.mcb.creditfactory.service.transport;

import com.mcb.creditfactory.dto.Dto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class GenericService<T extends Transport, E extends Dto>{

	@Autowired
	ExternalApproveService approveService;

	public abstract CrudRepository<T, Long> getRepository();


	public abstract boolean approve(E dto);


	public T save(T transport) {

		return getRepository().save(transport);
	}

	public Optional<T> load(Long id) {
		return getRepository().findById(id);
	}

	public abstract T fromDto(E dto);

	public abstract E toDTO(T transport);

	public Long getId(T transport) {
		return transport.getId();
	}



}
