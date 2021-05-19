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
import com.tunisair.entities.Habilitation;
import com.tunisair.service.HabilitationService;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/habilitation")
public class HabilitationController {
	@Autowired 
	HabilitationService Hs;
	
	// Ajout habilitation
   @PostMapping("/ajout")
	public Habilitation create(@Valid @RequestBody Habilitation H )
	{ 
	
		return Hs.save(H);
	}
   
   /* liste des Habilitations */
	@GetMapping(value="/findall")
	public List <Habilitation> findall(){	
		return  Hs.findall();
		}


}
