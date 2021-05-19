package com.tunisair.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tunisair.dao.HabilitationRepository;
import com.tunisair.entities.Habilitation;

@Service
public class HabilitationService {
	@Autowired
	HabilitationRepository HabilitationRepo;
	
	private static final Logger L = LogManager.getLogger(HabilitationService.class);
	
	/* Ajouter une Habilitation */
	public Habilitation save(Habilitation H) {

		return HabilitationRepo.save(H);

	}

	/* voir tous les Habilitations */
	public List<Habilitation> findall() {
		List<Habilitation> a = HabilitationRepo.findAll();

		for (Habilitation Habilitations : a) {
			L.info("Habilitation de détails  :" + Habilitations);

		}
		return a;
	}

	/* Delete D"une Habilitation */
	public void delete(long id) {
		HabilitationRepo.deleteById(id);
	}

	/* Update d'une Habilitation */
	public Habilitation updateFormation(Habilitation H) {
		return HabilitationRepo.save(H);

	}

	/* Chercher une Habilitation */
	public Habilitation findOne(long id_H) {
		return HabilitationRepo.getOne(id_H);
	}


}
