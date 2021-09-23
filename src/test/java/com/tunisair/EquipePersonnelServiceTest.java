package com.tunisair;


import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tunisair.entities.EquipePersonnel;
import com.tunisair.entities.UserEntity;
import com.tunisair.service.EquipePersonnelService;
import com.tunisair.service.EquipeService;
import com.tunisair.service.UserEntityService;

@SpringBootTest
public class EquipePersonnelServiceTest {
	
	@Autowired
	EquipePersonnelService ES;
	@Autowired
	UserEntityService US;
	@Autowired
	EquipeService ESS;
	@Test
	public void testFindall() {
		List<EquipePersonnel> equipeDetails = ES.findall();
		Assert.assertNotNull(equipeDetails);

	}
	@Test
	@Transactional
	public void testFindMembers() {
	EquipePersonnel ED =ES.save(US.findall().get(1).getId(), ESS.findall().get(1).getId());
      List<UserEntity> Member=ES.FindMembers(ESS.findall().get(1).getId());
      
      Assert.assertNotNull(Member);
	}
	@Test
	@Transactional
    public void testFindOne() {
		
		EquipePersonnel ED =ES.save(US.findall().get(1).getId(), ESS.findall().get(1).getId());
		EquipePersonnel EQD =ES.findOne(ED.getId());
        Assert.assertEquals(EQD.getPersonnel(), ED.getPersonnel());
        ES.delete(ED.getId());
       
       

	}
	@Test
	@Transactional
	public void testFindMembersAvailable() {
	
      List<UserEntity> Members=ES.FindMembersavailable();
      
      Assert.assertNotNull(Members);
	}

	
	

}
