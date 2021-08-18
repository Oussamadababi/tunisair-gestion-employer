package com.tunisair.entities;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tunisair.entities.personnel.Magasin;
import java.util.List;
import java.util.Set;

/**
 * The persistent class for the user_entity database table.
 * 
 */
@Entity
@Table(name = "user_entity")
@NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UserEntity {

	@Id
	private String id;

	@Column(name = "created_timestamp")
	private Long createdTimestamp;

	private String email;

	@Column(name = "email_constraint")
	private String emailConstraint;

	@Column(name = "email_verified")
	private Boolean emailVerified;

	private Boolean enabled;

	@Column(name = "federation_link")
	private String federationLink;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "not_before")
	private Integer notBefore;

	@Column(name = "realm_id")
	private String realmId;

	@Column(name = "service_account_client_link")
	private String serviceAccountClientLink;

	private String username;
	private String Matricule;
	private String Statut;
	private String Societe;
	private String Service;
	private String Assurance_qualite;
	private String Categorie;

	// Relation avec equipe
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Chef_equipe")
	@JsonIgnore
	private List<Equipe> ChefEquipe;
	// Relation
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "personnel")
	private List<Formation_Details> Formations_Details;
	@JsonIgnore
	public List<Formation_Details> getFormations_Details() {
		return Formations_Details;
	}

	public void setFormations_Details(List<Formation_Details> formations_Details) {
		Formations_Details = formations_Details;
	}

	// Relation
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "personnel")
	@JsonIgnore
	private Set<Qualification> Qualifications;

	// Relation
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "personnel")
	@JsonIgnore
	private Set<Habilitation> Habilitations;

	// Relation avec magasin many to one unidirectionnel (la personnel peut voir
	// les type de magasin alors que l'inverse non)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Magasin_id")
	Magasin Magasin;

	// Relation
	@OneToMany(mappedBy = "personnel", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)

	private List<EquipePersonnel> EquipePersonnel;

	// bi-directional many-to-one association to UserAttribute
	@OneToMany(mappedBy = "userEntity")
	private List<UserAttribute> userAttributes;

	public UserEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCreatedTimestamp() {
		return this.createdTimestamp;
	}

	public void setCreatedTimestamp(Long createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailConstraint() {
		return this.emailConstraint;
	}

	public void setEmailConstraint(String emailConstraint) {
		this.emailConstraint = emailConstraint;
	}

	public Boolean getEmailVerified() {
		return this.emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getFederationLink() {
		return this.federationLink;
	}

	public void setFederationLink(String federationLink) {
		this.federationLink = federationLink;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getNotBefore() {
		return this.notBefore;
	}

	public void setNotBefore(Integer notBefore) {
		this.notBefore = notBefore;
	}

	public String getRealmId() {
		return this.realmId;
	}

	public void setRealmId(String realmId) {
		this.realmId = realmId;
	}

	public String getServiceAccountClientLink() {
		return this.serviceAccountClientLink;
	}

	public void setServiceAccountClientLink(String serviceAccountClientLink) {
		this.serviceAccountClientLink = serviceAccountClientLink;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserAttribute> getUserAttributes() {
		return this.userAttributes;
	}

	public void setUserAttributes(List<UserAttribute> userAttributes) {
		this.userAttributes = userAttributes;
	}

	public UserAttribute addUserAttribute(UserAttribute userAttribute) {
		getUserAttributes().add(userAttribute);
		userAttribute.setUserEntity(this);

		return userAttribute;
	}

	public UserAttribute removeUserAttribute(UserAttribute userAttribute) {
		getUserAttributes().remove(userAttribute);
		userAttribute.setUserEntity(null);

		return userAttribute;
	}

	public String getMatricule() {
		return Matricule;
	}

	public void setMatricule(String matricule) {
		Matricule = matricule;
	}

	public String getStatut() {
		return Statut;
	}

	public void setStatut(String statut) {
		Statut = statut;
	}

	public String getSociete() {
		return Societe;
	}

	public void setSociete(String societe) {
		Societe = societe;
	}

	public String getService() {
		return Service;
	}

	public void setService(String service) {
		Service = service;
	}

	public String getAssurance_qualite() {
		return Assurance_qualite;
	}

	public void setAssurance_qualite(String assurance_qualite) {
		Assurance_qualite = assurance_qualite;
	}

	public String getCategorie() {
		return Categorie;
	}

	public void setCategorie(String categorie) {
		Categorie = categorie;
	}

	public Magasin getMagasin() {
		return Magasin;
	}

	public void setMagasin(Magasin magasin) {
		Magasin = magasin;
	}

	@Override
	public String toString() {
		return "UserEntity [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + "]";
	}

}