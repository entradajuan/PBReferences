package com.needine.pbreferences.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.needine.pbreferences.domain.Reference;

@Repository
public interface ReferenceRepository extends CrudRepository<Reference, Long> {

	Reference findByName(String name);
}
