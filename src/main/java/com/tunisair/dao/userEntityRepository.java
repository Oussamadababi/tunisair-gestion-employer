package com.tunisair.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tunisair.entities.UserEntity;

public interface userEntityRepository extends JpaRepository<UserEntity, String> {
	@Query(value = "SELECT id FROM keycloak_role where name=?1 ", nativeQuery = true)
	public  String GetRoleIdByName(String Role);
	@Query(value = "SELECT user_id FROM user_role_mapping where role_id=?1 ", nativeQuery = true)
	public  List<String> ListeDesIdPerso(String Id);
	@Query(value = "SELECT name FROM keycloak_role where name!='create-client' and name!='offline_access' and name!='view-applications' and name!='admin'and name!='create-realm' and name!='create-client' and name!='view-realm' and name!='create-client' and name!='view-users' and name!='view-clients' and name!='view-realm' and name!='create-client' and name!='view-events' and name!='view-identity-providers' and name!='view-authorization' and name!='manage-realm' and name!='manage-users' and name!='manage-clients' and name!='manage-events' and name!='manage-identity-providers' and name!='manage-authorization' and name!='query-users' and name!='query-clients' and name!='query-realms' and name!='query-groups' and name!='view-profile' and name!='manage-account' and name!='manage-account-links' and name!='view-consent' and name!='manage-consent' and name!='delete-account' and name!='read-token' and name!='impersonation' and name!='uma_authorization' and name!='realm-admin' and name!='impersonation' and name!='uma_authorization'", nativeQuery = true)
	public  List<String> ListeDesNouveauxRoles();
	
	@Query(value = "SELECT role_id,name FROM user_role_mapping INNER JOIN keycloak_role ON user_role_mapping.role_id = keycloak_role.id where user_id=?1 and name!='create-client' and name!='offline_access' and name!='view-applications' and name!='admin'and name!='create-realm' and name!='create-client' and name!='view-realm' and name!='create-client' and name!='view-users' and name!='view-clients' and name!='view-realm' and name!='create-client' and name!='view-events' and name!='view-identity-providers' and name!='view-authorization' and name!='manage-realm' and name!='manage-users' and name!='manage-clients' and name!='manage-events' and name!='manage-identity-providers' and name!='manage-authorization' and name!='query-users' and name!='query-clients' and name!='query-realms' and name!='query-groups' and name!='view-profile' and name!='manage-account' and name!='manage-account-links' and name!='view-consent' and name!='manage-consent' and name!='delete-account' and name!='read-token' and name!='impersonation' and name!='uma_authorization' and name!='realm-admin' and name!='impersonation' and name!='uma_authorization'", nativeQuery = true)
	public  List<Object> GetRoleByIdUser(String Iduser);
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM user_role_mapping WHERE role_id=?1 and user_id=?2", nativeQuery = true)
	public  void DeleteRoleUser(String IdRole,String IdUser);
	@Transactional
	@Modifying
	@Query(value = "UPDATE user_attribute SET  value=?1 WHERE user_id=?2 and name='image' ", nativeQuery = true)
	public  void UpdateProfilPic(String image,String IdUser);
	
	@Query(value = "SELECT  * FROM user_attribute WHERE user_id=?1 and name='image' ", nativeQuery = true)
	public  Object GetProfilPic(String IdUser);
	
	@Query(value = "SELECT * FROM user_entity where username=?1 ", nativeQuery = true)
	public  UserEntity GetUserbyUsername(String username);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE user_attribute SET  value=?1 WHERE user_id=?2 and name=?3 ", nativeQuery = true)
	public  void UpdateDetailUser(String value,String IdUser,String attribute);
	
	
	
	
	
	
	
	
	
}
