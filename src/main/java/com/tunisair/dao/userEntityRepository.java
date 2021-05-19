package com.tunisair.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.tunisair.entities.UserEntity;

public interface userEntityRepository extends JpaRepository<UserEntity, String> {
	@Query(value = "SELECT id FROM keycloak_role where name=?1 ", nativeQuery = true)
	public  String GetRoleIdByName(String Role);
	@Query(value = "SELECT user_id FROM user_role_mapping where role_id=?1 ", nativeQuery = true)
	public  List<String> ListeDesIdPerso(String Id);
	@Query(value = "SELECT name FROM keycloak_role where name!='create-client' and name!='offline_access' and name!='view-applications' and name!='admin'and name!='create-realm' and name!='create-client' and name!='view-realm' and name!='create-client' and name!='view-users' and name!='view-clients' and name!='view-realm' and name!='create-client' and name!='view-events' and name!='view-identity-providers' and name!='view-authorization' and name!='manage-realm' and name!='manage-users' and name!='manage-clients' and name!='manage-events' and name!='manage-identity-providers' and name!='manage-authorization' and name!='query-users' and name!='query-clients' and name!='query-realms' and name!='query-groups' and name!='view-profile' and name!='manage-account' and name!='manage-account-links' and name!='view-consent' and name!='manage-consent' and name!='delete-account' and name!='read-token' and name!='impersonation' and name!='uma_authorization' and name!='realm-admin' and name!='impersonation' and name!='uma_authorization'", nativeQuery = true)
	public  List<String> ListeDesNouveauxRoles();
	
	
	
	
}
