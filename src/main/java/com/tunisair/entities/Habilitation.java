package com.tunisair.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Habilitation {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	private String Organisme;
	private String Secteur;
	private String Code_Habilitation;
	private String Type_Habilitation;
	private String Numero;
	private String Libelle;
	private Date Date_debut;
	private Date Date_fin;
	private Date Debut_suspension;
	private Date Fin_suspension;

	// Relation
	// Relation entre la Formation et technicien
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	UserEntity personnel;

	// getters ans setters

	
	public String getOrganisme() {
		return Organisme;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public void setOrganisme(String organisme) {
		Organisme = organisme;
	}

	public String getSecteur() {
		return Secteur;
	}

	public void setSecteur(String secteur) {
		Secteur = secteur;
	}

	public String getCode_Habilitation() {
		return Code_Habilitation;
	}

	public void setCode_Habilitation(String code_Habilitation) {
		Code_Habilitation = code_Habilitation;
	}

	public String getType_Habilitation() {
		return Type_Habilitation;
	}

	public void setType_Habilitation(String type_Habilitation) {
		Type_Habilitation = type_Habilitation;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	public Date getDate_debut() {
		return Date_debut;
	}

	public void setDate_debut(Date date_debut) {
		Date_debut = date_debut;
	}

	public Date getDate_fin() {
		return Date_fin;
	}

	public void setDate_fin(Date date_fin) {
		Date_fin = date_fin;
	}

	public Date getDebut_suspension() {
		return Debut_suspension;
	}

	public void setDebut_suspension(Date debut_suspension) {
		Debut_suspension = debut_suspension;
	}

	public Date getFin_suspension() {
		return Fin_suspension;
	}

	public void setFin_suspension(Date fin_suspension) {
		Fin_suspension = fin_suspension;
	}
	

	public UserEntity getPersonnel() {
		return personnel;
	}

	public void setPersonnel(UserEntity personnel) {
		this.personnel = personnel;
	}

	// Constructeurs
	public Habilitation() {
		super();
	}

	public Habilitation(long id, String organisme, String secteur, String code_Habilitation, String type_Habilitation,
			String numero, String libelle, Date date_debut, Date date_fin, Date debut_suspension, Date fin_suspension,
			UserEntity personnel) {
		super();
		Id = id;
		Organisme = organisme;
		Secteur = secteur;
		Code_Habilitation = code_Habilitation;
		Type_Habilitation = type_Habilitation;
		Numero = numero;
		Libelle = libelle;
		Date_debut = date_debut;
		Date_fin = date_fin;
		Debut_suspension = debut_suspension;
		Fin_suspension = fin_suspension;
		this.personnel = personnel;
	}

	

}
