package com.tunisair;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tunisair.dao.FormationRepository;
import com.tunisair.entities.Formation;
import com.tunisair.entities.Formation_Details;
import com.tunisair.entities.UserEntity;
import com.tunisair.service.FormationService;
import com.tunisair.service.UserEntityService;


@SpringBootTest
public class FormationServiceTest {

	@Autowired
	FormationService FS;
	@Autowired
	FormationRepository FR;
	@Autowired
	UserEntityService US;
	@Test
	public void testFindall() {
		List<Formation> articles = FS.findall();
		Assert.assertNotNull(articles);

	}
	
	@Test
	public void testSave() {

		Formation F = new Formation(1, "test", "test","libelle","code",500,800,900,true,true,true);
		Formation F1 = FS.save(F);
		Assert.assertEquals(F.getNom_Formation(), FS.save(F1).getNom_Formation());
		FS.delete(F1.getId());

	}
	@Test
	public void testUpdateFormation() {
		Formation F = new Formation(1, "test", "test","libelle","code",500,800,900,true,true,true);
		Formation F1 = FS.save(F);
		F1.setNom_Formation("different");
		FS.updateFormation(F1);
		Assert.assertNotNull(F.getNom_Formation(),F1.getNom_Formation());
		FS.delete(F1.getId());

	}
	@Test
    public void testFindOne() {
		
		
		Formation F = new Formation(1, "test", "test","libelle","code",500,800,900,true,true,true);
		Formation F1 = FS.save(F);
		Formation art1 = FS.findOne(F.getId());
        Assert.assertNotNull(art1);
        FS.delete(F1.getId());

	}
	@Test
	public void testDelete () {
		Formation F = new Formation(1, "testjunit", "test","libelle","code",500,800,900,true,true,true);
		Formation F1 = FS.save(F);
		FS.delete(F1.getId());
		Formation c2 = new Formation();
		c2=FS.findOne(F1.getId());
		 Assert.assertNotEquals(c2, F1);
		 
		
	}
	@Test
	public void testListePersonnelNonAffecter() {
		Formation F = new Formation(1, "testjunit", "test","libelle","code",500,800,900,true,true,true);
		Formation F1 = FS.save(F);
		 List<UserEntity> ListeNonaffecter=FS.ListePersonnelNonAffecter(F1.getId());
		Assert.assertNotNull(ListeNonaffecter);
		FS.delete(F1.getId());

	}
	@Test
	@Transactional
	public void testUpdateDateExamen() throws ParseException {
		Formation F = new Formation(1, "testjunit", "test","libelle","code",500,800,900,true,true,true);
		Formation F1 = FS.save(F);
		LocalDateTime date = LocalDateTime.now();
		java.sql.Date date1 = java.sql.Date.valueOf("2016-10-25");
		Formation_Details FD= new Formation_Details(date,"etat",US.findall().get(1),F1);
		FS.updateDateExamen(date1, US.findall().get(1).getId(), F1.getId());
		Assert.assertNotEquals(FD.getDate_passage(), LocalDateTime.now());
		FS.desinscrireFormation(US.findall().get(1).getId(), F1.getId());
		FS.delete(F1.getId());

	}
	@Test
	public void testParticiperAuformation() {
		Formation F = new Formation(1, "testjunit", "test","libelle","code",500,800,900,true,true,true);
		Formation F1 = FS.save(F);
		Formation_Details FD=FS.ParticiperFormation(F1.getId(), US.findall().get(1).getId());
		Assert.assertNotNull(FD);
		FS.desinscrireFormation(US.findall().get(1).getId(), F1.getId());
		FS.delete(F1.getId());

	}
}
