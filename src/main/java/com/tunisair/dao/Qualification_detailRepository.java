package com.tunisair.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tunisair.entities.Qualification_details;

@Repository
public interface Qualification_detailRepository extends JpaRepository<Qualification_details, Long> {
	@Query(value = "SELECT * FROM qualification_details where idp=?1 ", nativeQuery = true)
	List<Qualification_details> ListeQualifParIdPerso(String IdP);
	@Query(value = "SELECT * FROM qualification_details where idq=?1 ", nativeQuery = true)
	List<Qualification_details> ListePersoParQualif(long IdP);
	

}
