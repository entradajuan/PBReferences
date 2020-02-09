package com.needine.pbreferences.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.needine.pbreferences.domain.BankAccount;
import com.needine.pbreferences.domain.Reference;
import com.needine.pbreferences.dto.OperationDTO;
import com.needine.pbreferences.movementsClient.MovementsClient;
import com.needine.pbreferences.movementsClient.movementsRestDAO.BankAccountRestDAO;
import com.needine.pbreferences.repository.ReferenceRepository;
import com.needine.pbreferences.repository.ServiceRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ServiceServiceImpl implements ServiceService{
	
	private ServiceRepository serviceRepository;
	private MovementsClient movementsClient; 

	@Autowired
	public ServiceServiceImpl(final ServiceRepository serviceRepository, final MovementsClient movementsClient) {
		this.serviceRepository = serviceRepository;
		this.movementsClient = movementsClient;
	}

	@Override
	public com.needine.pbreferences.domain.Service create(com.needine.pbreferences.domain.Service service) {
		List<BankAccount> bankAccounts = service.getBankAccounts().stream().map(e -> {
			e.setService(service);
			return e;}).collect(Collectors.toList());
		return serviceRepository.save(service);
	}

	@Override
	public List<com.needine.pbreferences.domain.Service> getAll() {
		return (List<com.needine.pbreferences.domain.Service>) serviceRepository.findAll();
	}

	@Override
	public List<Object[]> getServicesByReference(String referenceId) {
		List<Object[]> queryResult = serviceRepository.findByReferenceID(referenceId);
		if (!queryResult.isEmpty()) {
			log.info("getServicesByReference: Number of servicesByReference: {}", queryResult.size());			
		}else {
			log.info("getServicesByReference: servicesByReference: NONE");			
		}
		return queryResult;
	}

	@Override
	public OperationDTO doOperation(OperationDTO operationDTO) {
		log.info("Show Account for data: {}", operationDTO.getOriginAccount());
		BankAccountRestDAO bankAccountDAO = movementsClient.getOneAccount(operationDTO.getOriginAccount());
		if (bankAccountDAO!=null) {
			log.info("Retrieved data:  {}",  bankAccountDAO);
			operationDTO.setFinished("DONE");
		}else {
			log.info("Retrieved data:  NOT FOUND (404)");
			operationDTO.setFinished("NOT FOUND (404)");
		}
		return operationDTO;
	}

	

}
