package com.needine.pbreferences.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.needine.pbreferences.domain.Service;
import com.needine.pbreferences.dto.OperationDTO;

public interface ServiceService {

	List<Service> getAll();
	Service create(Service service);
	List<Object[]> getServicesByReference(String referenceId);
	OperationDTO doOperation(OperationDTO operationDTO);

}
