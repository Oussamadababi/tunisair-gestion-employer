package com.tunisair.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunisair.dao. EquipePersonnelRepository;
import com.tunisair.entities. EquipePersonnel;

@Service
public class  EquipePersonnelService {
	@Autowired
	 EquipePersonnelRepository  EquipePersonnelRepo;

	private static final Logger L = LogManager.getLogger( EquipePersonnelService.class);

	/* Ajouter une  EquipePersonnel */
	public  EquipePersonnel save( EquipePersonnel F) {

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


}
