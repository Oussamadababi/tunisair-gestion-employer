package com.tunisair.entities.personnel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Magasin {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	private String Magasin;
	private String Nom;
	
	
	//Getters and setters
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getMagasin() {
		return Magasin;
	}
	public void setMagasin(String magasin) {
		Magasin = magasin;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	
	//Constructeur
	public Magasin(long id, String magasin, String nom) {
		super();
		Id = id;
		Magasin = magasin;
		Nom = nom;
	}
	public Magasin() {
		super();
	}
	
	
	
}
