package com.needine.pbreferences.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.needine.pbreferences.domain.Reference;
import com.needine.pbreferences.repository.ReferenceRepository;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReferenceServiceImpl implements ReferenceService {

	private ReferenceRepository referenceRepository;

	@Autowired
	public ReferenceServiceImpl(final ReferenceRepository referenceRepository) {
		this.referenceRepository = referenceRepository;
	}
	
	@Override
	public List<Reference> getAll() {
		return (List<Reference>) referenceRepository.findAll();
	}

	@Override
	public Reference create(Reference reference) {
		return referenceRepository.save(reference);
	}

}
