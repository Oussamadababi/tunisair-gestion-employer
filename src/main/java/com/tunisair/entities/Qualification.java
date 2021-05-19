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
public class Qualification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String Secteur;
	private String Libelle_secteur;
	private String Qualification_type;
	private Date Date_debut;
	private Date Date_fin;

	// Relation entre la certification et technicien
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	UserEntity personnel;

	// getters and setters

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getSecteur() {
		return Secteur;
	}

	public void setSecteur(String secteur) {
		Secteur = secteur;
	}

	public String getLibelle_secteur() {
		return Libelle_secteur;
	}

	public void setLibelle_secteur(String libelle_secteur) {
		Libelle_secteur = libelle_secteur;
	}

	public String getQualification_type() {
		return Qualification_type;
	}

	public void setQualification_type(String qualification_type) {
		Qualification_type = qualification_type;
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

	

	public UserEntity getPersonnel() {
		return personnel;
	}

	public void setPersonnel(UserEntity personnel) {
		this.personnel = personnel;
	}

	// Constructeurs
	public Qualification(long id, String secteur, String libelle_secteur, String qualification_type, Date date_debut,
			Date date_fin, UserEntity personnel) {
		super();
		Id = id;
		Secteur = secteur;
		Libelle_secteur = libelle_secteur;
		Qualification_type = qualification_type;
		Date_debut = date_debut;
		Date_fin = date_fin;
		this.personnel = personnel;
	}

	public Qualification() {
		super();
	}

}
