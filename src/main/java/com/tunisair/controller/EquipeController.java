package com.tunisair.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tunisair.entities.Equipe;
import com.tunisair.service.EquipeService;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/Equipe")
public class EquipeController {
	
	@Autowired 
	EquipeService Es;
	
	// Ajout Equipe
   @PostMapping("/ajout")
	public Equipe create(@Valid @RequestBody Equipe E )
	{ 
	
		return Es.save(E);
	}
   
   /* liste des Equipes */
	@GetMapping(value="/findall")
	public List <Equipe> findall(){	
		return  Es.findall();
		}
	


}
