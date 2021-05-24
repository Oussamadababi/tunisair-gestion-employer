package com.tunisair.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the keycloak_role database table.
 * 
 */
@Entity
@Table(name="keycloak_role")
@NamedQuery(name="KeycloakRole.findAll", query="SELECT k FROM KeycloakRole k")
public class KeycloakRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String client;

	@Column(name="client_realm_constraint")
	private String clientRealmConstraint;

	@Column(name="client_role")
	private Boolean clientRole;

	private String description;

	private String name;

	private String realm;

	@Column(name="realm_id")
	private String realmId;

	public KeycloakRole() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClient() {
		return this.client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getClientRealmConstraint() {
		return this.clientRealmConstraint;
	}

	public void setClientRealmConstraint(String clientRealmConstraint) {
		this.clientRealmConstraint = clientRealmConstraint;
	}

	public Boolean getClientRole() {
		return this.clientRole;
	}

	public void setClientRole(Boolean clientRole) {
		this.clientRole = clientRole;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRealm() {
		return this.realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}

	public String getRealmId() {
		return this.realmId;
	}

	public void setRealmId(String realmId) {
		this.realmId = realmId;
	}

}