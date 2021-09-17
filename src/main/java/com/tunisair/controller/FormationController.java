package com.tunisair.controller;

import java.sql.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mailjet.client.errors.MailjetException;
import com.tunisair.entities.Formation;
import com.tunisair.entities.Formation_Details;
import com.tunisair.entities.UserEntity;
import com.tunisair.message.MessageResponse;
import com.tunisair.service.FormationService;



@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/formation")
public class FormationController {
	
	@Autowired 
	FormationService Fs;
	
	// Ajout formation
   @PostMapping("/ajout")
	public Formation create(@Valid @RequestBody Formation f )
	{ 
	
		return Fs.save(f);
	}
   
   //Patriciper au formation
// Ajout formation
   @PostMapping("/participer/{idF}/{idp}")
	public Formation_Details ParticiperFormation(@PathVariable(name="idF") Long id,@PathVariable(name="idp") String idp )
	{ 
	
		return Fs.ParticiperFormation(id,idp);
	}
   @GetMapping(value="/Personnelparticipe/{idf}")
	public List <Formation_Details> ParticiperAuForma(@PathVariable(name="idf") Long id){	
		return  Fs.ParticiperAuformation(id);
		}
	@GetMapping(value="/verifInscriFormation/{idF}/{idp}")
	public List <Formation_Details> verificationInscriptionFormation(@PathVariable(name="idF") Long id,@PathVariable(name="idp") String idp){	
		return  Fs.verficiationInscri(idp, id);
		}
   /* liste des formations */
	@GetMapping(value="/findall")
	public List <Formation> findall(){	
		return  Fs.findall();
		}
	
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable(name="id") Long id){
		Fs.delete(id);
		
	}
	@PutMapping(value="/update/{id}")
	public void update(@PathVariable(name="id") Long id,@RequestBody Formation p){
		Formation pers=Fs.findOne(id);
		pers.setCode(p.getCode());;
		pers.setCout(p.getCout());
		pers.setDiplome(p.isDiplome());
		pers.setDelais(p.getDelais());
		pers.setDuree(p.getDuree());
		pers.setFormation_repetitive(p.isFormation_repetitive());
		pers.setLibelle(p.getLibelle());
		pers.setNom_Formation(p.getNom_Formation());
		pers.setOrganisme(p.getOrganisme());
		final Formation updatedPersonnel=Fs.save(pers);
		
	}
	 /* liste de mes formations */
		@GetMapping(value="/findallMyFormation/{idp}")
		public List <Formation> findallMyformation(@PathVariable(name="idp") String idp){	
			return  Fs.ListeFormationParIdPersno(idp);
			}
		
		@DeleteMapping(value="/desinscrire/{idp}/{idf}")
		public ResponseEntity<?>  desincrireFormation(@PathVariable(name="idp") String idp,@PathVariable(name="idf") long idf){
			Fs.desinscrireFormation(idp, idf);
			return ResponseEntity.ok(new MessageResponse("le personnel est désinscris de la formations"));
		}
		/* liste des users non affecter */
		@GetMapping(value="/usersnonaffecter/{idf}")
		public List <UserEntity> usernonaffecterformation(@PathVariable(name="idf") long idf){	
			return  Fs.ListePersonnelNonAffecter(idf);
			}
		@PutMapping(value="/updateDate/{Date}/{idp}/{idf}")
		public void updateDateExamen(@PathVariable(name="Date") Date datee,
				@PathVariable(name="idp") String idp,@PathVariable(name="idf") long idf){
			
			Fs.updateDateExamen(datee, idp, idf);
		}
		@GetMapping(value="/envoyerMailExamen")
		public void envoyerMailExamen () {
			
			try {
				Fs.envoyerMailPersonnelDateExamen();
			
				// TODO Auto-generated catch block
				
			} catch (MailjetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@GetMapping(value="/envoyerMaildatedebutf")
		public void envoyerMaildebutFormation () {
			
			try {
				Fs.envoyerMailPersonnelDateDebut();
			
				// TODO Auto-generated catch block
				
			} catch (MailjetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@GetMapping(value="/envoyerMaildatefintf")
		public void envoyerMailFinFormtion () {
			
			try {
				Fs.envoyerMailPersonnelDateFin();
			
				// TODO Auto-generated catch block
				
			} catch (MailjetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
