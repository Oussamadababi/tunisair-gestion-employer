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

import com.tunisair.entities.Formation;
import com.tunisair.entities.Qualification;
import com.tunisair.service.QualificationService;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/qualification")
public class QualificationController {

	@Autowired 
	QualificationService Qs;
	
	// Ajout Qualification
   @PostMapping("/ajout")
	public Qualification create(@Valid @RequestBody Qualification Q )
	{ 
	
		return Qs.save(Q);
	}
   
   /* liste des Qualifications */
	@GetMapping(value="/findall")
	public List <Qualification> findall(){	
		return  Qs.findall();
		}
	//update qualification
	@PutMapping(value="/update/{id}")
	public void update(@PathVariable(name="id") Long id,@RequestBody Qualification p){
		Qualification pers=Qs.findOne(id);
		pers.setDate_debut(p.getDate_debut());
		pers.setDate_fin(p.getDate_fin());
		pers.setLibelle_secteur(p.getLibelle_secteur());
		pers.setQualification_type(p.getQualification_type());
		pers.setSecteur(p.getSecteur());
		
		
		final Qualification updatedPersonnel=Qs.save(pers);
		
	}
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable(name="id") Long id){
		Qs.delete(id);
	}
}
