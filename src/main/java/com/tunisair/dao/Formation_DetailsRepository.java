package com.tunisair.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tunisair.entities.Formation_Details;


@Repository
public interface Formation_DetailsRepository extends JpaRepository<Formation_Details, Long> {
	@Query(value = "SELECT * FROM formation_details where idp=?1 ", nativeQuery = true)
	List<Formation_Details> ListeFormationParIdPerso(String IdP);
	@Query(value = "SELECT * FROM formation_details where idf=?1 ", nativeQuery = true)
	List<Formation_Details> ListePersonnelParticiperAuFormation(long IdP);
	//SELECT * FROM formation_details where idf=?1
//SELECT * FROM formation_details where idp ='8d6d7a79-42e2-43c2-b200-c42ef671580b' and idf=3
	@Query(value = "SELECT * FROM formation_details where idp =?1 and idf=?2 ", nativeQuery = true)
	List<Formation_Details> verifInscriptionFormation(String idP,long idf);
}
