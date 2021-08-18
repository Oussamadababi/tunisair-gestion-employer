package com.tunisair.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunisair.dao.FormationRepository;
import com.tunisair.dao.Formation_DetailsRepository;
import com.tunisair.entities.Formation;
import com.tunisair.entities.Formation_Details;
import com.tunisair.entities.UserEntity;

@Service
public class FormationService {

	@Autowired
	FormationRepository FormationRepo;
	
	@Autowired
	Formation_DetailsRepository FDR;
	@Autowired
	UserEntityService UES;

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

	public Formation_Details ParticiperFormation(long idF,String idp ) {
	   Formation_Details  F = new Formation_Details();
	   F.setFormation(findOne(idF));
	   F.setPersonnel(UES.findOne(idp));
        F.setDate_passage(null);
        F.setEtat("En-cours");
		return FDR.save(F);

	}
	
	public List<Formation_Details> ParticiperAuformation(long idf) {
		List<Formation_Details> a = FDR.ListePersonnelParticiperAuFormation(idf);

		for (Formation_Details formations : a) {
			L.info("Formation de détails  :" + formations);

		}
		return a;
	}
	public List<Formation_Details> verficiationInscri(String idp,long idf) {
		List<Formation_Details> a = FDR.verifInscriptionFormation(idp, idf);

		for (Formation_Details formations : a) {
			L.info("Formation de détails  :" + formations);

		}
		return a;
	}
	public List<Formation> ListeFormationParIdPersno(String idp) {
		List<Formation_Details> a = FDR.ListeFormationParIdPerso(idp);
		List<Formation> mesFormation = new ArrayList();

		for (Formation_Details formations : a) {
			mesFormation.add(formations.getFormation());
		}
		return mesFormation;
	}
	public void desinscrireFormation(String idp,long idf) {
		FDR.DesInscriptionFormation(idp, idf);
	}
	
	public List<UserEntity> ListePersonnelNonAffecter(long idf){
		
		List<UserEntity> AllUsers=UES.findall();
		List<UserEntity> UsersNonAffecter = new ArrayList();
		List<Formation_Details> UsersAffecter =FDR.ListePersonnelParticiperAuFormation(idf);
		for( Formation_Details Formation_Details : UsersAffecter){
			UsersNonAffecter.add(Formation_Details.getPersonnel());	
		}
		AllUsers.removeAll(UsersNonAffecter);
		return AllUsers;
		}
		
		
	
	
}
