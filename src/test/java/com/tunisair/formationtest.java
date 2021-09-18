package com.tunisair;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tunisair.entities.Formation;
import com.tunisair.service.FormationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class formationtest {

	@Autowired
	FormationService FS;

	@Test
	public void testAfficherFormations() {
		List<Formation> articles = FS.findall();
		Assert.assertNotNull(articles);

	}
	
	@Test
	public void testAjoutFormations() {

		Formation F = new Formation(1, "test", "test","libelle","code",500,800,900,true,true,true);
		Formation F1 = FS.save(F);
		Assert.assertEquals(F.getNom_Formation(), FS.save(F1).getNom_Formation());

	}
	@Test
	public void testModifierFormation() {
		List<Formation> articles = FS.findall();
		Assert.assertNotNull(articles);

	}
	@Test
	public void testSupprimerFormation() {
		List<Formation> articles = FS.findall();
		Assert.assertNotNull(articles);

	}


}
