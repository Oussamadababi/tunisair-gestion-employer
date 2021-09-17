package com.tunisair.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tunisair.entities.EquipePersonnel;


@Repository
public interface EquipePersonnelRepository  extends JpaRepository<EquipePersonnel, Long>{
	@Query(value = "SELECT * FROM equipe_personnel where id_equipe=?1", nativeQuery = true)
	public  List<EquipePersonnel> ListeMembreByIdGroupe(long IdEquipe);
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "DELETE FROM equipe_personnel WHERE id_equipe=?1 and id_personnel=?2", nativeQuery = true)
	public  void deleteMemberofEquipe(long idequipe,String IdP);
	
	//
	
}
