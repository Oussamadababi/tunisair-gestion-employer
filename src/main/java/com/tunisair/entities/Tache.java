package com.tunisair.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tache {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String Nom;
	private String Description;
	private Date Date_debut;
	private boolean status;

	// Relation
	@ManyToOne
	@JoinColumn(name = "idEquipe")
	private Equipe Equipe;

	// Getters and setters

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Equipe getEquipe() {
		return Equipe;
	}

	public void setEquipe(Equipe equipe) {
		Equipe = equipe;
	}

	public Date getDate_debut() {
		return Date_debut;
	}

	public void setDate_debut(Date date_debut) {
		Date_debut = date_debut;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	//Constructeurs
	public Tache() {
		super();
	}

	public Tache(long id, String nom, String description, Date date_debut, boolean status,
			com.tunisair.entities.Equipe equipe) {
		super();
		Id = id;
		Nom = nom;
		Description = description;
		Date_debut = date_debut;
		this.status = status;
		Equipe = equipe;
	}
	
	
}
