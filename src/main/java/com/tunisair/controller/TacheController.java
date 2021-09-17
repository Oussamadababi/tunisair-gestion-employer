package com.tunisair.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunisair.dao.TacheRepository;
import com.tunisair.entities.Equipe;
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
   @PostMapping("/ajout/{ide}")
	public Tache create(@Valid @RequestBody Tache f,@PathVariable(name="ide") long IdE )
	{ 
	
		return Fs.save(f,IdE);
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
	
	// Change Etat Tache Finish
	   @PutMapping("/updateStatusF/{ide}")
		public void ChangeStatusTacheF(@PathVariable(name="ide") long IdT )
		{ 
		
			 Fs.ChangeStatusFinish(IdT);
			 Tr.save(Fs.findOne(IdT));
		}
	// Change Etat Tache en cours
	   @PutMapping("/updateStatusT/{ide}")
		public void ChangeStatusTacheT(@PathVariable(name="ide") long IdT )
		{ 
		
			 Fs.ChangeStatusTrue(IdT);
			 Tr.save(Fs.findOne(IdT));
			 
		}
		@PutMapping(value="/update/{id}")
		public void update(@PathVariable(name="id") Long id,@RequestBody Tache p){
			Tache eq=Fs.findOne(id);
			eq.setNom(p.getNom());
			eq.setDescription(p.getDescription());
			eq.setStatus(p.isStatus());
			eq.setDate_debut(p.getDate_debut());
			eq.setEquipe(p.getEquipe());
			final Tache updateTache=Fs.update2(eq);
			
		}
		//////////////stat
		@GetMapping(value="/statequipelastthreeMonth")
		public List <Integer> StatTacheEquipelastthreeMonth(){	
			return  Tr.StatTacheEquipelastthreeMonth();
			}
		@GetMapping(value="/statequipelastsixMonth")
		public List <Integer> StatTacheEquipelastsixMonth(){	
			return  Tr.StatTacheEquipelastsixMonth();
			}

		@GetMapping(value="/statequipelastnineMonth")
		public List <Integer> StatTacheEquipelastnineMonth(){	
			return  Tr.StatTacheEquipelastnineMonth();
			}
		//Statname
		@GetMapping(value="/statequipelastthreeMonthN")
		public List <String> StatTacheEquipelastthreeMonthN(){	
			return  Tr.StatTacheEquipelastthreeMonthName();
			}
		@GetMapping(value="/statequipelastsixMonthN")
		public List <String> StatTacheEquipelastsixMonthN(){	
			return  Tr.StatTacheEquipelastsixMonthName();
			}

		@GetMapping(value="/statequipelastnineMonthN")
		public List <String> StatTacheEquipelastnineMonthN(){	
			return  Tr.StatTacheEquipelastnineMonthName();
			}
		

		


}
