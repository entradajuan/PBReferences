package com.needine.pbreferences.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}
