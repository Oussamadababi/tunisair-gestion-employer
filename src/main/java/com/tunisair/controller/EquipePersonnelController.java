package com.tunisair.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunisair.entities.EquipePersonnel;
import com.tunisair.entities.UserEntity;
import com.tunisair.message.MessageResponse;
import com.tunisair.service.EquipePersonnelService;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/EquipePersonnel")
public class EquipePersonnelController {
	
	@Autowired 
	EquipePersonnelService Ep;
	
	// Ajout EquipePersonnel
   @PostMapping("/ajout/{Id}/{IdE}")
	public EquipePersonnel create(@PathVariable(name="Id") String IdP,@PathVariable(name="IdE") Long IdEquipe)
	{ 
	
		return Ep.save(IdP,IdEquipe);
	}
   
   /* liste des EquipePersonnels */
	@GetMapping(value="/findall")
	public List <EquipePersonnel> findall(){	
		return  Ep.findall();
		}
	
    /* liste des des members */
	@GetMapping(value="/findallMembers/{IdEquipe}")
	public List <UserEntity> findMembers(@PathVariable(name="IdEquipe") long IdEquipe){	
			return  Ep.FindMembers(IdEquipe);
		}
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable(name="id") Long id){
		Ep.delete(id);
		
	}
	@DeleteMapping(value="/deletemember/{ide}/{idp}")
	public ResponseEntity<?>  desincrireFormation(@PathVariable(name="ide") long ide,@PathVariable(name="idp") String idp){
		Ep.DeleteMemberByIDP(ide,idp);
		return ResponseEntity.ok(new MessageResponse("le personnel  de la groupe"));
	}
	@GetMapping(value="/findallMembersavailable")
	public List <UserEntity> findMembersavailable(){	
			return  Ep.FindMembersavailable();
		}

}
