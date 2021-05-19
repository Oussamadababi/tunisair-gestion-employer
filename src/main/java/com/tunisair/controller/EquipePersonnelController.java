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
import com.tunisair.entities.EquipePersonnel;
import com.tunisair.service.EquipePersonnelService;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/EquipePersonnel")
public class EquipePersonnelController {
	
	@Autowired 
	EquipePersonnelService Fs;
	
	// Ajout EquipePersonnel
   @PostMapping("/ajout")
	public EquipePersonnel create(@Valid @RequestBody EquipePersonnel f )
	{ 
	
		return Fs.save(f);
	}
   
   /* liste des EquipePersonnels */
	@GetMapping(value="/findall")
	public List <EquipePersonnel> findall(){	
		return  Fs.findall();
		}


}
