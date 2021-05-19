package com.tunisair.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tunisair.entities.Formation;




@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
	
	/*@Query(value = "SELECT * FROM formation where personnel_id =?1; ", nativeQuery = true)
	List<Formation> ListeFormationParIdPerso(long IdP);*/

}
