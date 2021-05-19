package com.tunisair.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunisair.dao.QualificationRepository;
import com.tunisair.entities.Qualification;

@Service
public class QualificationService {
	
	@Autowired
	QualificationRepository QualificationRepo;
	
	private static final Logger L = LogManager.getLogger(QualificationService.class);
	
	/* Ajouter une Qualification */
	public Qualification save(Qualification Qualification) {

		return QualificationRepo.save(Qualification);

	}

	/* voir tous les Qualifications */
	public List<Qualification> findall() {
		List<Qualification> a = QualificationRepo.findAll();

		for (Qualification Qualification : a) {
			L.info("Qualification :" + Qualification);

		}
		return a;
	}

	/* Delete D"une Qualifications */
	public void delete(long id) {
		QualificationRepo.deleteById(id);
	}

	/* Update d'une Qualification */
	public Qualification updateQuali(Qualification Q) {
		return QualificationRepo.save(Q);

	}

	/* Chercher une Qualification */
	public Qualification findOne(long id_Q) {
		return QualificationRepo.getOne(id_Q);
	}


}
