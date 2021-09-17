package com.tunisair.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunisair.entities.Equipe;
import com.tunisair.entities.Formation;
import com.tunisair.service.EquipeService;
import com.tunisair.service.UserEntityService;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/equipe")
public class EquipeController {
	
	@Autowired 
	EquipeService Es;
	@Autowired 
	UserEntityService UES;
	
	// Ajout Equipe
   @PostMapping("/ajout/{id}")
	public Equipe create(@Valid @RequestBody Equipe E,@PathVariable(name="id") String id )
	{ 
         E.setChef_equipe(UES.findOne(id));;
		return Es.save(E);
	}
   
   /* liste des Equipes */
	@GetMapping(value="/findall")
	public List <Equipe> findall(){	
		return  Es.findall();
		}
	 /* liste des Equipes Par id User */
		@GetMapping(value="/findEquipeByIdUser/{Id}")
		public List <Equipe> findall(@PathVariable(name="Id") String IdP){	
			return  Es.findEquipeByIdUser(IdP);
			}
		
		@PutMapping(value="/update/{id}")
		public void update(@PathVariable(name="id") Long id,@RequestBody Equipe p){
			Equipe eq=Es.findOne(id);
			eq.setNom(p.getNom());
			final Equipe updateEquipe=Es.save(eq);
			
		}
		@DeleteMapping(value="/delete/{id}")
		public void delete(@PathVariable(name="id") Long id){
			Es.delete(id);
		}

}
