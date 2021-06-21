package com.tunisair.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunisair.dao.TacheRepository;
import com.tunisair.entities.Tache;
import com.tunisair.service.TacheService;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/Tache")
public class TacheController {
	
	@Autowired 
	TacheService Fs;
	@Autowired 
	TacheRepository Tr;
	
	// Ajout Tache
   @PostMapping("/ajout")
	public Tache create(@Valid @RequestBody Tache f )
	{ 
	
		return Fs.save(f);
	}
   
   /* liste des Taches */
	@GetMapping(value="/topEquipe")
	public List <Integer> topEquipe(){	
		return  Tr.topEquipe();
		}
	@GetMapping(value="/topEquipeNom")
	public List <String> topEquipeNom(){	
		return  Tr.TopEquipeNom();
		}
	@GetMapping(value="/findall")
	public List <Tache> findall(){	
		return  Fs.findall();
		}
	@GetMapping(value="/findByEq/{Id}")
	public List <Tache> findByEquipe(@PathVariable(name="Id") long IdE){	
		return  Fs.findByEquipe(IdE);
		}


}
