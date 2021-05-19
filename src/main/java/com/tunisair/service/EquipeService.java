package com.tunisair.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunisair.dao.EquipeRepository;
import com.tunisair.entities.Equipe;

@Service
public class EquipeService {
	@Autowired
	EquipeRepository EquipeRepo;

	private static final Logger L = LogManager.getLogger(EquipeService.class);

	/* Ajouter une Equipe */
	public Equipe save(Equipe F) {

		return EquipeRepo.save(F);

	}

	/* voir tous les s */
	public List<Equipe> findall() {
		List<Equipe> a = EquipeRepo.findAll();

		for (Equipe Equipes : a) {
			L.info("Equipe de détails  :" + Equipes);

		}
		return a;
	}

	/* Delete D"une Equipe */
	public void delete(long id) {
		EquipeRepo.deleteById(id);
	}

	/* Update d'une Equipe */
	public Equipe updateEquipe(Equipe F) {
		return EquipeRepo.save(F);

	}

	/* Chercher une Equipe */
	public Equipe findOne(long id_F) {
		return EquipeRepo.getOne(id_F);
	}


}
