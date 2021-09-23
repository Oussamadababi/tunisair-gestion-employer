package com.tunisair;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tunisair.entities.Qualification;
import com.tunisair.entities.Qualification_details;
import com.tunisair.entities.UserEntity;
import com.tunisair.service.QualificationService;
import com.tunisair.service.UserEntityService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QualificationServiceTest {

	@Autowired
	QualificationService QS;
	@Autowired
	UserEntityService US;
	@Test
	public void testAffichageQualifications() {
		List<Qualification> qualifs = QS.findall();
		Assert.assertNotNull(qualifs);

	}

	@Test
	public void testSave() {

		Qualification Q = new Qualification(1, "testjunit", "testjunit","libelle");
		Qualification Q1 = QS.save(Q);
		Assert.assertEquals(Q.getSecteur(), QS.save(Q1).getSecteur());
		QS.delete(Q1.getId());

	}
	@Test
	public void testUpdateQuali() {

		Qualification Q = new Qualification(1, "testjunit", "testjunit","libelle");
		Qualification Q1 = QS.save(Q);
		Q1.setSecteur("different");
		QS.updateQuali(Q1);
		Assert.assertNotEquals(Q.getSecteur(),Q1.getSecteur());
		QS.delete(Q1.getId());

	}
	@Test
	public void testDelete() {

		Qualification Q = new Qualification(1, "testjunit", "testjunit","libelle");
		Qualification Q1 = QS.save(Q);
		QS.delete(Q1.getId());
		Qualification Q2 = QS.findOne(Q.getId());
		Assert.assertNotEquals(Q1,Q2);

	}
	@Test
	public void testListePersoParIdQualif() {

		Qualification Q = new Qualification(1, "testjunit", "testjunit","libelle");
		Qualification Q1 = QS.save(Q);
		java.sql.Date date1 = java.sql.Date.valueOf("2016-10-25");
		java.sql.Date date2 = java.sql.Date.valueOf("2018-10-25");
		Qualification_details QD = new Qualification_details(date1,date2,US.findall().get(1),Q1);
		QS.saveQD(US.findall().get(1).getId(), Q1.getId(), QD);
		List<UserEntity> ListeUserParQualif = QS.ListePersoParIdQualif(Q1.getId());
		Assert.assertNotNull(ListeUserParQualif);
		QS.delete(Q1.getId());

	}

}
