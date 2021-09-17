package com.tunisair.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.resource.Emailv31;
import com.tunisair.dao.FormationRepository;
import com.tunisair.dao.Formation_DetailsRepository;
import com.tunisair.entities.Formation;
import com.tunisair.entities.Formation_Details;
import com.tunisair.entities.UserEntity;



@Service
public class FormationService {

	@Autowired
	FormationRepository FormationRepo;

	@Autowired
	Formation_DetailsRepository FDR;
	@Autowired
	UserEntityService UES;

	private static final Logger L = LogManager.getLogger(FormationService.class);

	/* Ajouter une Formation */
	public Formation save(Formation F) {

		return FormationRepo.save(F);

	}

	/* voir tous les Formations */
	public List<Formation> findall() {
		List<Formation> a = FormationRepo.findAll();

		for (Formation formations : a) {
			L.info("Formation de détails  :" + formations);

		}
		return a;
	}

	/* Delete D"une Formation */
	public void delete(long id) {
		FormationRepo.deleteById(id);
	}

	/* Update d'une Formation */
	public Formation updateFormation(Formation F) {
		return FormationRepo.save(F);

	}

	/* Chercher une Formation */
	public Formation findOne(long id_F) {
		return FormationRepo.getOne(id_F);
	}

	public Formation_Details ParticiperFormation(long idF, String idp) {
		Formation_Details F = new Formation_Details();
		F.setFormation(findOne(idF));
		F.setPersonnel(UES.findOne(idp));
		F.setDate_passage(null);
		F.setEtat("En-cours");
		return FDR.save(F);

	}

	public List<Formation_Details> ParticiperAuformation(long idf) {
		List<Formation_Details> a = FDR.ListePersonnelParticiperAuFormation(idf);

		for (Formation_Details formations : a) {
			L.info("Formation de détails  :" + formations);

		}
		return a;
	}

	public List<Formation_Details> verficiationInscri(String idp, long idf) {
		List<Formation_Details> a = FDR.verifInscriptionFormation(idp, idf);

		for (Formation_Details formations : a) {
			L.info("Formation de détails  :" + formations);

		}
		return a;
	}

	public List<Formation> ListeFormationParIdPersno(String idp) {
		List<Formation_Details> a = FDR.ListeFormationParIdPerso(idp);
		List<Formation> mesFormation = new ArrayList();

		for (Formation_Details formations : a) {
			mesFormation.add(formations.getFormation());
		}
		return mesFormation;
	}

	public void desinscrireFormation(String idp, long idf) {
		FDR.DesInscriptionFormation(idp, idf);
	}

	public void updateDateExamen(Date D, String idp, long idf) {
		FDR.updateDateExamen(D, idp, idf);
	}

	public List<UserEntity> ListePersonnelNonAffecter(long idf) {

		List<UserEntity> AllUsers = UES.findall();
		List<UserEntity> UsersNonAffecter = new ArrayList();
		List<Formation_Details> UsersAffecter = ParticiperAuformation(idf);
		for (Formation_Details Formation_Details : UsersAffecter) {
			UsersNonAffecter.add(Formation_Details.getPersonnel());
		}
		AllUsers.removeAll(UsersNonAffecter);
		return AllUsers;
	}

	// Envoyer Mail au personnel pour informer au date des formations

public void envoyerMailPersonnelDateExamen() throws  MailjetException{
	
	
	List<Formation_Details> UsersAffecter =FDR.findAll();
//	for(Formation_Details Fd : UsersAffecter){
//		int Jexamen=Fd.getDate_passage().getDayOfMonth();
//		int JAujourdhui=java.time.LocalDateTime.now().getDayOfMonth();
//		int Mexamen=Fd.getDate_passage().getMonthValue();
//		int MAujourdhui=java.time.LocalDateTime.now().getMonthValue();
//		int Yexamen=Fd.getDate_passage().getYear();
//		int YAujourdhui=java.time.LocalDateTime.now().getYear();
//	
		
//		if(Jexamen-JAujourdhui==3&Mexamen-MAujourdhui==0&-Yexamen-YAujourdhui==0){
		
			
			
//		}
//		
//	}
	

    MailjetRequest request;
    MailjetResponse response;
    ClientOptions options = ClientOptions.builder()
            .apiKey("141128976bc6ab6f6a50b75cceba7158")
            .apiSecretKey("b94447eb612f28b5a24bcbcf67ec6961")
            .build();
      
      MailjetClient client = new MailjetClient(options);
  //  client = new MailjetClient("141128976bc6ab6f6a50b75cceba7158","b94447eb612f28b5a24bcbcf67ec6961", new ClientOptions("v3.1"));
    try {
		request = new MailjetRequest(Emailv31.resource)
		.property(Emailv31.MESSAGES, new JSONArray()
		.put(new JSONObject()
		.put(Emailv31.Message.FROM, new JSONObject()
		.put("Email", "tunisairtechnicstest@gmail.com")
		.put("Name", "tunisair"))
		.put(Emailv31.Message.TO, new JSONArray()
		.put(new JSONObject()
		.put("Email", "firas.warteni15@gmail.com")
		.put("Name", "tunisair")))
		.put(Emailv31.Message.SUBJECT, "Rappel de la date de passage d'examen")
		.put(Emailv31.Message.TEXTPART, "Rappel de la date de passage")
		.put(Emailv31.Message.HTMLPART, "<h4>   Bonjour Mr/Mme Firas Trabelsi </h4><br/><p>Nous avons l 'honneur de vous envoyé ce mail pour vous informer que la date de passage d'examen de la formation  <strong>aéronautique</strong> est le <strong>28/08/2021</strong> à l'heure <strong>9h:00</strong>.</p><br/><p>Ce mail est envoyé avant 3 jrs de la date de passage.<p> <br/> <p>Pour plus d'informations vous pouvez consulter votre espace.<p> <br/><h4>Bonne courage et bonne chance.</h4>")
		.put(Emailv31.Message.CUSTOMID, "Rappel de la date de passage")));
		response = client.post(request);
		System.out.println(response.getStatus());
	    System.out.println(response.getData());
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
  }

public void envoyerMailPersonnelDateDebut() throws  MailjetException{
	
	
	List<Formation_Details> UsersAffecter =FDR.findAll();
//	for(Formation_Details Fd : UsersAffecter){
//		int Jexamen=Fd.getDate_passage().getDayOfMonth();
//		int JAujourdhui=java.time.LocalDateTime.now().getDayOfMonth();
//		int Mexamen=Fd.getDate_passage().getMonthValue();
//		int MAujourdhui=java.time.LocalDateTime.now().getMonthValue();
//		int Yexamen=Fd.getDate_passage().getYear();
//		int YAujourdhui=java.time.LocalDateTime.now().getYear();
//	
		
//		if(Jexamen-JAujourdhui==3&Mexamen-MAujourdhui==0&-Yexamen-YAujourdhui==0){
		
			
			
//		}
//		
//	}
	

    MailjetRequest request;
    MailjetResponse response;
    ClientOptions options = ClientOptions.builder()
            .apiKey("141128976bc6ab6f6a50b75cceba7158")
            .apiSecretKey("b94447eb612f28b5a24bcbcf67ec6961")
            .build();
      
      MailjetClient client = new MailjetClient(options);
  //  client = new MailjetClient("141128976bc6ab6f6a50b75cceba7158","b94447eb612f28b5a24bcbcf67ec6961", new ClientOptions("v3.1"));
    try {
		request = new MailjetRequest(Emailv31.resource)
		.property(Emailv31.MESSAGES, new JSONArray()
		.put(new JSONObject()
		.put(Emailv31.Message.FROM, new JSONObject()
		.put("Email", "tunisairtechnicstest@gmail.com")
		.put("Name", "tunisair"))
		.put(Emailv31.Message.TO, new JSONArray()
		.put(new JSONObject()
		.put("Email", "firas.warteni15@gmail.com")
		.put("Name", "tunisair")))
		.put(Emailv31.Message.SUBJECT, "Rappel de la date de debut du formation")
		.put(Emailv31.Message.TEXTPART, "Rappel de la date de debut du formation")
		.put(Emailv31.Message.HTMLPART, "<h4>   Bonjour Mr/Mme Firas Trabelsi </h4><br/><p>Nous avons l 'honneur de vous envoyé ce mail pour vous informer que la date de debut de la formation  <strong>aéronautique</strong> est le <strong>28/08/2021</strong> à l'heure <strong>9h:00</strong>.</p><br/><p>Ce mail est envoyé avant 3 jrs de la date de passage.<p> <br/> <p>Pour plus d'informations vous pouvez consulter votre espace.<p> <br/><h4>Bonne courage et bonne chance.</h4>")
		.put(Emailv31.Message.CUSTOMID, "Rappel de la date de debut du formation")));
		response = client.post(request);
		System.out.println(response.getStatus());
	    System.out.println(response.getData());
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
  }

public void envoyerMailPersonnelDateFin() throws  MailjetException{
	
	
	List<Formation_Details> UsersAffecter =FDR.findAll();
//	for(Formation_Details Fd : UsersAffecter){
//		int Jexamen=Fd.getDate_passage().getDayOfMonth();
//		int JAujourdhui=java.time.LocalDateTime.now().getDayOfMonth();
//		int Mexamen=Fd.getDate_passage().getMonthValue();
//		int MAujourdhui=java.time.LocalDateTime.now().getMonthValue();
//		int Yexamen=Fd.getDate_passage().getYear();
//		int YAujourdhui=java.time.LocalDateTime.now().getYear();
//	
		
//		if(Jexamen-JAujourdhui==3&Mexamen-MAujourdhui==0&-Yexamen-YAujourdhui==0){
		
			
			
//		}
//		
//	}
	

    MailjetRequest request;
    MailjetResponse response;
    ClientOptions options = ClientOptions.builder()
            .apiKey("141128976bc6ab6f6a50b75cceba7158")
            .apiSecretKey("b94447eb612f28b5a24bcbcf67ec6961")
            .build();
      
      MailjetClient client = new MailjetClient(options);
  //  client = new MailjetClient("141128976bc6ab6f6a50b75cceba7158","b94447eb612f28b5a24bcbcf67ec6961", new ClientOptions("v3.1"));
    try {
		request = new MailjetRequest(Emailv31.resource)
		.property(Emailv31.MESSAGES, new JSONArray()
		.put(new JSONObject()
		.put(Emailv31.Message.FROM, new JSONObject()
		.put("Email", "tunisairtechnicstest@gmail.com")
		.put("Name", "tunisair"))
		.put(Emailv31.Message.TO, new JSONArray()
		.put(new JSONObject()
		.put("Email", "firas.warteni15@gmail.com")
		.put("Name", "tunisair")))
		.put(Emailv31.Message.SUBJECT, "Rappel de la date de fin du formation")
		.put(Emailv31.Message.TEXTPART, "Rappel de la date de fin du formation")
		.put(Emailv31.Message.HTMLPART, "<h4>   Bonjour Mr/Mme Firas Trabelsi </h4><br/><p>Nous avons l 'honneur de vous envoyé ce mail pour vous informer que la date de fin de la formation  <strong>aéronautique</strong> est le <strong>28/08/2021.</p><br/><p>Ce mail est envoyé avant 3 jrs de la date de passage.<p> <br/> <p>Pour plus d'informations vous pouvez consulter votre espace.<p> <br/><h4>Bonne courage et bonne chance.</h4>")
		.put(Emailv31.Message.CUSTOMID, "Rappel de la date de debut du formation")));
		response = client.post(request);
		System.out.println(response.getStatus());
	    System.out.println(response.getData());
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
  }		
		
}


