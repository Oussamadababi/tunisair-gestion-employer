package com.tunisair.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunisair.dao.QualificationRepository;
import com.tunisair.dao.Qualification_detailRepository;
import com.tunisair.entities.Qualification;
import com.tunisair.entities.Qualification_details;
import com.tunisair.entities.UserEntity;

@Service
public class QualificationService {
	
	@Autowired
	QualificationRepository QualificationRepo;
	@Autowired
	Qualification_detailRepository QDR;
	@Autowired
	UserEntityService UES;
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
	public List<Qualification_details> findQualifByIdUser(String IdP) {
	

		return QDR.ListeQualifParIdPerso(IdP);
	}
	public List<UserEntity> ListePersoParIdQualif(long Idq) {
		
       List<Qualification_details> ListeDetailsParQualif =QDR.ListePersoParQualif(Idq);
       List<UserEntity> ListeUserParQualif = new ArrayList();
       for(Qualification_details Qd : ListeDetailsParQualif)
       {
    	   ListeUserParQualif.add(Qd.getPersonnel());
       }
       return ListeUserParQualif;
	}

	public Qualification_details saveQD(String idp,long idq,Qualification_details Qualification) {
        UserEntity Ue= new UserEntity();
        Ue=UES.findOne(idp);
        Qualification Q = new Qualification();
        Q=QualificationRepo.getOne(idq);
        Qualification.setQualification(Q);
        Qualification.setPersonnel(Ue);
		return QDR.save(Qualification);

	}

}
