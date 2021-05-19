package com.tunisair.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tunisair.entities.Tache;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {
//SELECT  COUNT(*) FROM tache JOIN equipe ON tache.id_equipe = equipe.id group by equipe.id order by equipe.nom asc 
//SELECT  equipe.nom FROM tache JOIN equipe ON tache.id_equipe = equipe.id group by equipe.id order by equipe.nom asc 
	
	@Query(value = "SELECT  COUNT(*) FROM tache JOIN equipe ON tache.id_equipe = equipe.id group by equipe.id order by equipe.nom asc ", nativeQuery = true)
	public  List<Integer> topEquipe();
	
	@Query(value = "SELECT  equipe.nom FROM tache JOIN equipe ON tache.id_equipe = equipe.id group by equipe.id order by equipe.nom asc ", nativeQuery = true)
	public  List<String> TopEquipeNom();
}
