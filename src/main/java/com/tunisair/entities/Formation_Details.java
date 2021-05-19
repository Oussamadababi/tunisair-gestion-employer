package com.tunisair.entities;

import java.io.Serializable;
import java.sql.Date;

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
	private Date Date_debut;
	private Date Date_fin;
	private Date Date_passage;

	// Relation avec entité formation et personnel (Porteuse de données)
	@ManyToOne
	@JoinColumn(name = "idP", insertable = false, updatable = false)
	private UserEntity personnel;
	@ManyToOne
	@JoinColumn(name = "idF", insertable = false, updatable = false)
	private Formation formation;

	// getters and setters
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
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

	public Date getDate_passage() {
		return Date_passage;
	}

	public void setDate_passage(Date date_passage) {
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

	public Formation_Details(long id, Date date_debut, Date date_fin, Date date_passage, UserEntity personnel,
			Formation formation) {
		super();
		Id = id;
		Date_debut = date_debut;
		Date_fin = date_fin;
		Date_passage = date_passage;
		this.personnel = personnel;
		this.formation = formation;
	}

	public Formation_Details() {
		super();
	}

}
