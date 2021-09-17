package com.tunisair.entities;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Qualification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String Secteur;
	private String Libelle_secteur;
	private String Qualification_type;

	// Relation entre la certification et technicien
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "qualification")
	@JsonIgnore
	private List<Qualification_details> Qualification_details;
	@JsonIgnore

	// getters and setters

	

	public List<Qualification_details> getQualification_details() {
		return Qualification_details;
	}

	public void setQualification_details(List<Qualification_details> qualification_details) {
		Qualification_details = qualification_details;
	}
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

	
	// Constructeurs
	

	public Qualification() {
		super();
	}

	public Qualification(long id, String secteur, String libelle_secteur, String qualification_type) {
		super();
		Id = id;
		Secteur = secteur;
		Libelle_secteur = libelle_secteur;
		Qualification_type = qualification_type;
	}

}
