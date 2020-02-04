package com.needine.pbreferences.service;

import java.util.List;

import com.needine.pbreferences.domain.Reference;

public interface ReferenceService {
	
	List<Reference> getAll();
	Reference create(Reference reference);

}
