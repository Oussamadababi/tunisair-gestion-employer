package com.tunisair;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.tunisair.entities.Equipe;
import com.tunisair.entities.Tache;
import com.tunisair.service.EquipeService;
import com.tunisair.service.TacheService;
import com.tunisair.service.UserEntityService;


@SpringBootTest
public class TacheServiceTest {

	@Autowired
	TacheService TS;
	@Autowired
	UserEntityService US;
	@Autowired
	EquipeService ES;
	@Test
	public void testFindall() {
		List<Tache> taches = TS.findall();
		Assert.assertNotNull(taches);

	}

	@Test
	public void testSave() {
		//UserEntity user= new UserEntity("id4515",(long) 16302998,"test@gmail.com", "test@gmail.com", true, true, "link", "prenom", "nom",0, "tunisair-realm","test","02521");
		Equipe E =new Equipe("NomEquipetestjunit",US.findall().get(1));
		ES.save(E);
		java.sql.Date date1 = java.sql.Date.valueOf("2016-10-25");
		Tache T = new Tache( "testjunit", "test",date1,true,E);
		Tache T1 = TS.save(T,E.getId());
		Assert.assertEquals(T.getNom(), T1.getNom());
		TS.delete(T1.getId());
		ES.delete(E.getId());

	}
	@Test
	@Transactional
	public void testUpdateTache() {

		Equipe E =new Equipe("NomEquipetestjunit",US.findall().get(1));
		ES.save(E);
		java.sql.Date date1 = java.sql.Date.valueOf("2016-10-25");
		Tache T = new Tache("testjunit", "testjunit",date1,true,E);
		Tache T1 = TS.save(T,E.getId());
		//T1.setStatus(false);
		Tache T2=TS.update2(T1);
		Assert.assertNotNull(T2);
		TS.delete(T1.getId());
		ES.delete(E.getId());

	}
	@Test
	@Transactional
	public void testChangeStatusFinish() {

		
		boolean etat=TS.findall().get(2).isStatus();
		Tache T1 = TS.findall().get(2);
		TS.ChangeStatusFinish(T1.getId());
		Assert.assertEquals(T1.isStatus(),false);
		TS.findall().get(1).setStatus(etat);

	}
	@Test
	@Transactional
	public void testChangeStatusTrue() {

		boolean etat=TS.findall().get(1).isStatus();
		Tache T1 = TS.findall().get(1);
		TS.ChangeStatusTrue(T1.getId());
		Assert.assertEquals(T1.isStatus(),true);
		TS.findall().get(1).setStatus(etat);
	}
	@Test
	public void testFindByEquipe() {
		
		Equipe E =new Equipe("NomEquipetestjunit",US.findall().get(1));
		ES.save(E);
		java.sql.Date date1 = java.sql.Date.valueOf("2016-10-25");
		Tache T = new Tache( "testJunit", "testJunit",date1,true,E);
		Tache T1 = TS.save(T,E.getId());
		List<Tache> taches = TS.findByEquipe(E.getId());
		Assert.assertNotNull(taches);
		TS.delete(T1.getId());
		ES.delete(E.getId());

	}

}
