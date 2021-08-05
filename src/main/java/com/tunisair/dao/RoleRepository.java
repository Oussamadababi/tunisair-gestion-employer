package com.tunisair.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tunisair.entities.KeycloakRole;

public interface RoleRepository extends JpaRepository<KeycloakRole, String> {
	@Query(value = "SELECT * FROM keycloak_role where name=?1 and realm_id =?2 ", nativeQuery = true)
	public  KeycloakRole GetRoleIdByName(String Role,String Realm);
}
