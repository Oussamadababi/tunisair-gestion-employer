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
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String Nom;
	private String Chef_equipe;

	// Relation avec les détails d equipe
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Equipe")
	private List<EquipePersonnel> EquipePersonnel;

	// Relation aves les taches
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Equipe")
	private List<Tache> Taches;

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

	public String getChef_equipe() {
		return Chef_equipe;
	}

	public void setChef_equipe(String chef_equipe) {
		Chef_equipe = chef_equipe;
		}

	public List<EquipePersonnel> getEquipePersonnel() {
		return EquipePersonnel;
	}

	public void setEquipePersonnel(List<EquipePersonnel> equipePersonnel) {
		EquipePersonnel = equipePersonnel;
	}

	public Equipe(long id, String nom, String chef_equipe,
			List<com.tunisair.entities.EquipePersonnel> equipePersonnel) {
		super();
		Id = id;
		Nom = nom;
		Chef_equipe = chef_equipe;
		EquipePersonnel = equipePersonnel;
	}

	public Equipe() {
		super();
	}

}
