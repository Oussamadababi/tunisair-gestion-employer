package com.tunisair.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tunisair.entities.Qualification;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long>{
	@Query(value = "SELECT * FROM qualification where personnel_id =?1  ", nativeQuery = true)
	List<Qualification> ListeQualificationbyIdPerso(String IdP);
	
}
