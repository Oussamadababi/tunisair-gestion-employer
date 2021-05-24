package com.tunisair.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunisair.dao.userEntityRepository;
import com.tunisair.entities.UserEntity;

import com.tunisair.service.UserEntityService;



@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired 
	UserEntityService Us;
	@Autowired
	userEntityRepository UER;
	
	// Ajout User

	
	/* liste de Users */
	@GetMapping(value="/findallusers")
	public List <UserEntity> findall(){	
		return  Us.findall();
		}
	
	/*Liste des  personnels*/
	@GetMapping(value="/findallPerso")
	public List <UserEntity> findallPerso(){	
		return  Us.findallPerso();
		}
	
	/*Liste des  Role*/
	@GetMapping(value="/FindRole")
	public List <String> FindRole(){	
		return  Us.findRole();
		}
	
	/*Liste des  Role by Iduser*/
	@GetMapping(value="/FindRoleByIdUser/{Iduser}")
	public List <Object> FindRoleByidU(@PathVariable(name="Iduser") String Iduser){	
		return  Us.findRoleByIdUser(Iduser);
		}
	//test push git
	@Transactional
	@DeleteMapping(value="/delete/{idr}/{idUser}")
	public void delete(@PathVariable(name="idr") String idr,@PathVariable(name="idUser") String idUser){
		Us.deleteRoleUser(idr, idUser);
		
	}

	
}
