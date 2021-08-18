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
	@Query(value = "SELECT equipe_personnel.id,first_name,last_name,equipe_personnel.id_equipe FROM user_entity INNER JOIN equipe_personnel ON user_entity.id = equipe_personnel.id_personnel where id_equipe=?1", nativeQuery = true)
	public  List<Object> ListeMembreByIdGroupe(Long IdEquipe);
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "DELETE FROM equipe_personnel WHERE id_personnel=?1", nativeQuery = true)
	public  void deleteMemberofEquipe(String IdP);
	
	//
	
}
