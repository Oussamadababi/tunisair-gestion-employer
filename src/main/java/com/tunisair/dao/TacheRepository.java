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
	
	@Query(value = "SELECT  COUNT(*) FROM tache JOIN equipe ON tache.id_equipe = equipe.id where tache.status=false group by equipe.id order by equipe.nom asc ", nativeQuery = true)
	public  List<Integer> topEquipe();
	
	@Query(value = "SELECT  equipe.nom FROM tache JOIN equipe ON tache.id_equipe = equipe.id where tache.status=false group by equipe.id order by equipe.nom asc ", nativeQuery = true)
	public  List<String> TopEquipeNom();
	
	//SELECT * FROM tache where id_equipe=1?;
	@Query(value = " SELECT * FROM tache where id_equipe=?1", nativeQuery = true)
	public  List<Tache> ListeTacheParIdEquipe(long id);
	/////3month
	@Query(value = "SELECT  COUNT(*) FROM tache JOIN equipe ON tache.id_equipe = equipe.id where tache.status=false and tache.date_debut BETWEEN DATE( NOW() )- interval '3' MONTH AND   DATE( NOW() ) group by equipe.id order by equipe.nom asc LIMIT 4", nativeQuery = true)
	public  List<Integer> StatTacheEquipelastthreeMonth();
	@Query(value = "SELECT  equipe.nom FROM tache JOIN equipe ON tache.id_equipe = equipe.id where tache.status=false and tache.date_debut BETWEEN DATE( NOW() )- interval '3' MONTH AND   DATE( NOW() ) group by equipe.id order by equipe.nom asc LIMIT 4", nativeQuery = true)
	public  List<String> StatTacheEquipelastthreeMonthName();
	
    /////6month-3
	@Query(value = "SELECT  COUNT(*) FROM tache JOIN equipe ON tache.id_equipe = equipe.id where tache.status=false and tache.date_debut BETWEEN DATE( NOW() )- interval '6' MONTH AND   DATE( NOW() )- interval '3' group by equipe.id order by equipe.nom asc LIMIT 4", nativeQuery = true)
	public  List<Integer> StatTacheEquipelastsixMonth();
	@Query(value = "SELECT  equipe.nom FROM tache JOIN equipe ON tache.id_equipe = equipe.id where tache.status=false and tache.date_debut BETWEEN DATE( NOW() )- interval '6' MONTH AND   DATE( NOW() )- interval '3' group by equipe.id order by equipe.nom asc LIMIT 4", nativeQuery = true)
	public  List<String> StatTacheEquipelastsixMonthName();
	
/////9month-6
	@Query(value = "SELECT  COUNT(*) FROM tache JOIN equipe ON tache.id_equipe = equipe.id where tache.status=false and tache.date_debut BETWEEN DATE( NOW() )- interval '9' MONTH AND   DATE( NOW() )- interval '6' group by equipe.id order by equipe.nom asc LIMIT 4 ", nativeQuery = true)
	public  List<Integer> StatTacheEquipelastnineMonth();
	@Query(value = "SELECT  equipe.nom FROM tache JOIN equipe ON tache.id_equipe = equipe.id where tache.status=false and tache.date_debut BETWEEN DATE( NOW() )- interval '9' MONTH AND   DATE( NOW() )- interval '6' group by equipe.id order by equipe.nom asc LIMIT 4 ", nativeQuery = true)
	public  List<String> StatTacheEquipelastnineMonthName();
	
	//
}
