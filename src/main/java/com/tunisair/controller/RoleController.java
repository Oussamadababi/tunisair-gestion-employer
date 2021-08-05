package com.tunisair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunisair.entities.KeycloakRole;
import com.tunisair.service.RoleService;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired 
	RoleService RS;
	
	@GetMapping(value="/getrole/{name}")
	public KeycloakRole  GetRoleByname(@PathVariable(name="name") String name){	
		return  RS.GetRolebyName(name);
		}
}
