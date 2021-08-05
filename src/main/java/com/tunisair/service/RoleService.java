package com.tunisair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunisair.dao.RoleRepository;
import com.tunisair.entities.KeycloakRole;

@Service
public class RoleService {
	
	
	@Autowired
	RoleRepository RoleRp;
	
	public KeycloakRole GetRolebyName(String F) {
        String Realm="tunisair-realm";
		return RoleRp.GetRoleIdByName(F,Realm);

	}
}
