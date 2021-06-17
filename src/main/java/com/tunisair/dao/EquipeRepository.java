package com.tunisair.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tunisair.entities.Equipe;


@Repository
public interface EquipeRepository  extends JpaRepository<Equipe, Long>{
	@Query(value = "SELECT id, nom, chef_equipe FROM equipe where chef_equipe=?1", nativeQuery = true)
	List<Equipe> ListeEquipeParIdUserChefEquipe(String IdU);
	
	//SELECT id, nom, chef_equipe FROM public.equipe where chef_equipe='eba74707-61c2-4654-a03b-d28cc45a2ef4';;

}
