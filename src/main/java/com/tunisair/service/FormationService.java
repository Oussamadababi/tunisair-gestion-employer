package com.tunisair.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunisair.dao.FormationRepository;
import com.tunisair.dao.Formation_DetailsRepository;
import com.tunisair.entities.Formation;
import com.tunisair.entities.Formation_Details;

@Service
public class FormationService {

	@Autowired
	FormationRepository FormationRepo;
	
	@Autowired
	Formation_DetailsRepository FDR;

	private static final Logger L = LogManager.getLogger(FormationService.class);

	/* Ajouter une Formation */
	public Formation save(Formation F) {

		return FormationRepo.save(F);

	}

	/* voir tous les Formations */
	public List<Formation> findall() {
		List<Formation> a = FormationRepo.findAll();

		for (Formation formations : a) {
			L.info("Formation de détails  :" + formations);

		}
		return a;
	}

	/* Delete D"une Formation */
	public void delete(long id) {
		FormationRepo.deleteById(id);
	}

	/* Update d'une Formation */
	public Formation updateFormation(Formation F) {
		return FormationRepo.save(F);

	}

	/* Chercher une Formation */
	public Formation findOne(long id_F) {
		return FormationRepo.getOne(id_F);
	}

	public Formation_Details ParticiperFormation(Formation_Details F) {
        F.setDate_debut(null);
        F.setDate_fin(null);
        F.setDate_passage(null);
		return FDR.save(F);

	}
	
	public List<Formation_Details> ParticiperAuformation(long idf) {
		List<Formation_Details> a = FDR.ListePersonnelParticiperAuFormation(idf);

		for (Formation_Details formations : a) {
			L.info("Formation de détails  :" + formations);

		}
		return a;
	}
}
