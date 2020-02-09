package com.needine.pbreferences.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.needine.pbreferences.domain.Service;


@Repository
public interface ServiceRepository extends CrudRepository<Service, Long> {
	
	@Query(value = "select s.id, s.name, ref.name as 'refId'  " + 
			"from service s "
			+ "join reference ref on (s.reference_id = ref.id AND ref.name= ?1)" 
			, nativeQuery = true)
	List<Object[]> findByReferenceID(String referenceId);	

}
