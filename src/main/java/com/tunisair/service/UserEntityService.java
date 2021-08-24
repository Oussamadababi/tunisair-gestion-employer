package com.tunisair.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunisair.dao.userEntityRepository;
import com.tunisair.entities.Formation;
import com.tunisair.entities.UserEntity;


@Service
public class UserEntityService {
	@Autowired
	userEntityRepository UER;
	
	private static final Logger L = LogManager.getLogger(TacheService.class);


	/* voir tous les UserEntity */
	public List<UserEntity> findall() {
		List<UserEntity> a = UER.findAll();
	
        return a;
	}

	/* voir tous les personnel */
	public List<UserEntity> findallPerso() {
		List<UserEntity> ListePerso=new ArrayList();
		List<String> ListeIdparPerso = UER.ListeDesIdPerso(UER.GetRoleIdByName("personnel"));
		for (String ListeP : ListeIdparPerso) {
			ListePerso.add(UER.getOne(ListeP));

		}
        return ListePerso;
	}
	/* voir tous les Role */
	public List<String> findRole() {
		   return UER.ListeDesNouveauxRoles();
	}
	
	/* voir tous les Role by user Id */
	public List<Object> findRoleByIdUser(String Iduser) {
		   return UER.GetRoleByIdUser(Iduser);
	}
	
	/* Delete D"une Role User */
	public void deleteRoleUser(String idR,String IdUser) {
		UER.DeleteRoleUser(idR, IdUser);
	}
	public UserEntity findOne(String id_F) {
		return UER.getOne(id_F);
	}
	
	public void ChangeDetailUser(String value,String Idu,String attribute){
		 UER.UpdateDetailUser(value, Idu, attribute);
		
	}
	
	public List<UserEntity> FindUserByRole() {
		List<UserEntity> ListePerso=new ArrayList();
		List<String> ListeIdparPerso = UER.ListeDesIdPerso(UER.GetRoleIdByName("chef equipe"));
		for (String ListeP : ListeIdparPerso) {
			ListePerso.add(UER.getOne(ListeP));

		}
        return ListePerso;
	
}
}