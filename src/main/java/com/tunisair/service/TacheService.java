package com.tunisair.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tunisair.dao.TacheRepository;
import com.tunisair.entities.Tache;

@Service
public class TacheService {

	@Autowired
	TacheRepository TacheRepo;

	private static final Logger L = LogManager.getLogger(TacheService.class);

	/* Ajouter une Tache */
	public Tache save(Tache F) {

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

	/* Update d'une Tache */
	public Tache updateTache(Tache F) {
		return TacheRepo.save(F);

	}

	/* Chercher une Tache */
	public Tache findOne(long id_F) {
		return TacheRepo.getOne(id_F);
	}

}
