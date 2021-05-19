package com.tunisair.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String Organisme;
	private String Nom_Formation;
	private String Libelle;
	private String Code;
	private Integer Duree; // Par jours
	private Integer Cout; // Par dinars
	private Integer Delais;
	private boolean Aeronotique;
	private boolean Formation_repetitive;
	private boolean Diplome;

	// Relation entre la Formation et technicien
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "formation")
	private List<Formation_Details> Formations_Details;

	public List<Formation_Details> getFormations_Details() {
		return Formations_Details;
	}

	public void setFormations_Details(List<Formation_Details> formations_Details) {
		Formations_Details = formations_Details;
	}

	// getters and setters
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getOrganisme() {
		return Organisme;
	}

	public void setOrganisme(String organisme) {
		Organisme = organisme;
	}

	public String getNom_Formation() {
		return Nom_Formation;
	}

	public void setNom_Formation(String nom_Formation) {
		Nom_Formation = nom_Formation;
	}

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public Integer getDuree() {
		return Duree;
	}

	public void setDuree(Integer duree) {
		Duree = duree;
	}

	public Integer getCout() {
		return Cout;
	}

	public void setCout(Integer cout) {
		Cout = cout;
	}

	public Integer getDelais() {
		return Delais;
	}

	public void setDelais(Integer delais) {
		Delais = delais;
	}

	public boolean isAeronotique() {
		return Aeronotique;
	}

	public void setAeronotique(boolean aeronotique) {
		Aeronotique = aeronotique;
	}

	public boolean isFormation_repetitive() {
		return Formation_repetitive;
	}

	public void setFormation_repetitive(boolean formation_repetitive) {
		Formation_repetitive = formation_repetitive;
	}

	public boolean isDiplome() {
		return Diplome;
	}

	public void setDiplome(boolean diplome) {
		Diplome = diplome;
	}

	// Constructeur

	public Formation() {
		super();
	}

	public Formation(long id, String organisme, String nom_Formation, String libelle, String code, Integer duree,
			Integer cout, Integer delais, boolean aeronotique, boolean formation_repetitive, boolean diplome,
			List<Formation_Details> formations_Details) {
		super();
		Id = id;
		Organisme = organisme;
		Nom_Formation = nom_Formation;
		Libelle = libelle;
		Code = code;
		Duree = duree;
		Cout = cout;
		Delais = delais;
		Aeronotique = aeronotique;
		Formation_repetitive = formation_repetitive;
		Diplome = diplome;
		Formations_Details = formations_Details;
	}

}
