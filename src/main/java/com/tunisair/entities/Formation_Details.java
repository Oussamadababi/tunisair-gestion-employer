package com.tunisair.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Formation_Details implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	private LocalDateTime  Date_passage;
	private String Etat;

	// Relation avec entité formation et personnel (Porteuse de données)
	@ManyToOne
	@JoinColumn(name = "idP")
	private UserEntity personnel;
	@ManyToOne
	@JoinColumn(name = "idF")
	private Formation formation;

	// getters and setters
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	

	public LocalDateTime getDate_passage() {
		return Date_passage;
	}

	public void setDate_passage(LocalDateTime date_passage) {
		Date_passage = date_passage;
	}

	public UserEntity getPersonnel() {
		return personnel;
	}

	public void setPersonnel(UserEntity personnel) {
		this.personnel = personnel;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}

	


	public Formation_Details(long id, LocalDateTime date_passage, String etat, UserEntity personnel,
			Formation formation) {
		super();
		Id = id;
		Date_passage = date_passage;
		Etat = etat;
		this.personnel = personnel;
		this.formation = formation;
	}

	public Formation_Details(LocalDateTime date_passage, String etat, UserEntity personnel, Formation formation) {
		super();
		Date_passage = date_passage;
		Etat = etat;
		this.personnel = personnel;
		this.formation = formation;
	}

	public Formation_Details() {
		super();
	}

}
