package com.needine.pbreferences.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.needine.pbreferences.domain.BankAccount;
import com.needine.pbreferences.domain.Reference;
import com.needine.pbreferences.repository.ReferenceRepository;
import com.needine.pbreferences.repository.ServiceRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ServiceServiceImpl implements ServiceService{
	
	private ServiceRepository serviceRepository;

	@Autowired
	public ServiceServiceImpl(final ServiceRepository serviceRepository) {
		this.serviceRepository = serviceRepository;
	}

	@Override
	public com.needine.pbreferences.domain.Service create(com.needine.pbreferences.domain.Service service) {
		// TODO Auto-generated method stub
		List<BankAccount> bankAccounts = service.getBankAccounts().stream().map(e -> {
			e.setService(service);
			return e;}).collect(Collectors.toList());
		return serviceRepository.save(service);
	}

	@Override
	public List<com.needine.pbreferences.domain.Service> getAll() {
		// TODO Auto-generated method stub
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



}
