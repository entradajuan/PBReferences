package com.needine.pbreferences.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//		List<com.needine.pbreferences.domain.Service> servicesByReferenceList = queryResult.stream().map(e -> {
//			com.needine.pbreferences.domain.Service service = new com.needine.pbreferences.domain.Service((Long)e[0], ""+e[1], e[2], e[3]);
//			return service;
//			}).collect(Collectors.toList());
		return queryResult;
	}



}
