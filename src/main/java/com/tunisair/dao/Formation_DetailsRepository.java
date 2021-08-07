package com.tunisair.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tunisair.entities.Formation_Details;


@Repository
public interface Formation_DetailsRepository extends JpaRepository<Formation_Details, Long> {
	@Query(value = "SELECT * FROM formation_details where id_personnel=?1 ", nativeQuery = true)
	List<Formation_Details> ListeFormationParIdPerso(long IdP);
	@Query(value = "SELECT * FROM formation_details where idf=?1 ", nativeQuery = true)
	List<Formation_Details> ListePersonnelParticiperAuFormation(long IdP);
	//SELECT * FROM formation_details where idf=?1

}
