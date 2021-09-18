package com.tunisair;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.tunisair.entities.Qualification;
import com.tunisair.service.QualificationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Equipetest {

	@Autowired
	QualificationService QS;

	@Test
	public void testAffichageEquipes() {
		List<Qualification> qualifs = QS.findall();
		Assert.assertNotNull(qualifs);

	}

	@Test
	public void testAjoutEquipe() {

		Qualification Q = new Qualification(1, "test", "test","libelle");
		Qualification Q1 = QS.save(Q);
		Assert.assertEquals(Q.getSecteur(), QS.save(Q1).getSecteur());

	}
	@Test
	public void testModifierEquipe() {

		Qualification Q = new Qualification(1, "test", "test","libelle");
		Qualification Q1 = QS.save(Q);
		Assert.assertEquals(Q.getSecteur(), QS.save(Q1).getSecteur());

	}
	@Test
	public void testSupprimerEquipe() {

		Qualification Q = new Qualification(1, "test", "test","libelle");
		Qualification Q1 = QS.save(Q);
		Assert.assertEquals(Q.getSecteur(), QS.save(Q1).getSecteur());

	}

}
