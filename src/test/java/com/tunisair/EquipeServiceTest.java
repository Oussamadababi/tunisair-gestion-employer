package com.tunisair;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.tunisair.entities.Equipe;
import com.tunisair.entities.UserEntity;
import com.tunisair.service.EquipeService;
import com.tunisair.service.UserEntityService;


@SpringBootTest
public class EquipeServiceTest {

	@Autowired
	EquipeService ES;
	@Autowired
	UserEntityService US;


	@Test
	public void testSave() {

		Equipe E =new Equipe(8555,"NomEquipe");
		Equipe E2 =ES.save(E);
		Assert.assertEquals(E.getNom(),E2.getNom());
		ES.delete(E2.getId());

	}
	@Test
	public void testUpdateEquipe() {

		Equipe E =new Equipe(856,"NomEquipe");
		Equipe E2 =ES.save(E);
		E2.setNom("Different");
		ES.updateEquipe(E2);
		Assert.assertNotEquals(E.getNom(), E2.getNom());
		ES.delete(E2.getId());

	}
	@Test
    public void testFindEquipeByIdUser() {
		
		UserEntity user= US.findall().get(2);
		Equipe E =new Equipe(5151,"Test",user);
		Equipe E2 =ES.save(E);
		List<Equipe> ListEquipe=ES.findEquipeByIdUser(user.getId());
        Assert.assertNotNull(ListEquipe);
        ES.delete(E2.getId());

	}
	@Test
    public void testFindOne() {
		
		
		
		Equipe E =new Equipe(481,"Test");
		Equipe E2 =ES.save(E);
		Equipe E3 = ES.findOne(E2.getId());
        Assert.assertNotNull(E3);
        ES.delete(E2.getId());

	}


}
