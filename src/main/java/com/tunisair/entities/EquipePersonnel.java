package com.tunisair.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class EquipePersonnel   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private LocalDate Date_creation;
	private LocalDate Date_fermeture;
	private boolean etat;
	// Relation avec entité formation et personnel (Porteuse de données)
	@ManyToOne
	@JoinColumn(name = "idPersonnel")
	private UserEntity personnel;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "idEquipe")
	private Equipe Equipe;

	// getters and setters

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public LocalDate getDate_creation() {
		return Date_creation;
	}

	public void setDate_creation(LocalDate date_creation) {
		Date_creation = date_creation;
	}

	public LocalDate getDate_fermeture() {
		return Date_fermeture;
	}

	public void setDate_fermeture(LocalDate date_fermeture) {
		Date_fermeture = date_fermeture;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}


	public UserEntity getPersonnel() {
		return personnel;
	}

	public void setPersonnel(UserEntity personnel) {
		this.personnel = personnel;
	}

	public void setEquipe(Equipe equipe) {
		Equipe = equipe;
	}
	//Constructeurs
	public EquipePersonnel() {
		super();
	}

	public EquipePersonnel(long id, LocalDate date_creation, LocalDate date_fermeture, boolean etat,
			UserEntity personnel, com.tunisair.entities.Equipe equipe) {
		super();
		Id = id;
		Date_creation = date_creation;
		Date_fermeture = date_fermeture;
		this.etat = etat;
		this.personnel = personnel;
		Equipe = equipe;
	}

	
	
	
	
	

}
