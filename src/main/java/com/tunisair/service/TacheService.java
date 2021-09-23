package com.tunisair.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunisair.dao.TacheRepository;
import com.tunisair.entities.Equipe;
import com.tunisair.entities.Tache;

@Service
public class TacheService {

	@Autowired
	TacheRepository TacheRepo;
	
	@Autowired
	EquipeService RS;

	private static final Logger L = LogManager.getLogger(TacheService.class);

	/* Ajouter une Tache */
	public Tache save(Tache F,long ide) {
		Equipe Equi=RS.findOne(ide);
		F.setEquipe(Equi);
        F.setStatus(true);
		return TacheRepo.save(F);

	}


	/* voir tous les Taches */
	public List<Tache> findall() {
		List<Tache> a = TacheRepo.findAll();

		for (Tache Taches : a) {
			L.info("Tache de détails  :" + Taches);

		}
		return a;
	}

	/* Delete D"une Tache */
	public void delete(long id) {
		TacheRepo.deleteById(id);
	}

	

	/* Chercher une Tache */
	public Tache findOne(long id_F) {
		return TacheRepo.getOne(id_F);
	}
	/* voir tous les Taches par equipe */
	public List<Tache> findByEquipe(long id) {
		List<Tache> a = TacheRepo.ListeTacheParIdEquipe(id);

		for (Tache Taches : a) {
			L.info("Tache de détails  :" + Taches);

		}
		return a;
	}
	/* changer etat  Tache */
	public void ChangeStatusFinish(long idT) {
		 Tache T=TacheRepo.getOne(idT);
		 T.setStatus(false);
	}
	/* changer etat Tache true */
	public void ChangeStatusTrue(long idT) {
		 Tache T=TacheRepo.getOne(idT);
		 T.setStatus(true);
	}
	public Tache update2(Tache F) {
		return TacheRepo.save(F);

	}
	
	

}
