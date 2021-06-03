package com.tunisair.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunisair.dao. EquipePersonnelRepository;
import com.tunisair.dao.EquipeRepository;
import com.tunisair.dao.userEntityRepository;
import com.tunisair.entities.Equipe;
import com.tunisair.entities. EquipePersonnel;
import com.tunisair.entities.UserEntity;

@Service
public class  EquipePersonnelService {
	@Autowired
	 EquipePersonnelRepository  EquipePersonnelRepo;
	@Autowired
	userEntityRepository UER;
	@Autowired
	EquipeRepository EPR;

	private static final Logger L = LogManager.getLogger( EquipePersonnelService.class);

	/* Ajouter une  EquipePersonnel */
	public  EquipePersonnel save(String IdPersonnel,long idEquipe) {
		EquipePersonnel F = new EquipePersonnel();
		F.setDate_creation(java.time.LocalDate.now());
		F.setEtat(true);
		F.setDate_fermeture(null);
		UserEntity a=UER.getOne(IdPersonnel);
		F.setPersonnel(a);
		Equipe P = EPR.getOne(idEquipe);
		F.setEquipe(P);
	
		

		return  EquipePersonnelRepo.save(F);

	}

	/* voir tous les s */
	public List< EquipePersonnel> findall() {
		List< EquipePersonnel> a =  EquipePersonnelRepo.findAll();

		for ( EquipePersonnel  EquipePersonnels : a) {
			L.info(" EquipePersonnel de détails  :" +  EquipePersonnels);

		}
		return a;
	}

	/* Delete D"une  EquipePersonnel */
	public void delete(long id) {
		 EquipePersonnelRepo.deleteById(id);
	}

	/* Update d'une  EquipePersonnel */
	public  EquipePersonnel updateEquipePersonnel( EquipePersonnel F) {
		return  EquipePersonnelRepo.save(F);

	}

	/* Chercher une  EquipePersonnel */
	public  EquipePersonnel findOne(long id_F) {
		return  EquipePersonnelRepo.getOne(id_F);
	}
	/* Chercher Les membres d'equipe by idEquipe */
	public List< Object> FindMembers(Long IdEquipe) {
		List< Object> a =  EquipePersonnelRepo.ListeMembreByIdGroupe(IdEquipe);
		return a;
	}

}
