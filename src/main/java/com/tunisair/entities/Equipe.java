package com.tunisair.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String Nom;
	
	//Relation equipe et chef d'equipe avec userentity
	@ManyToOne
	@JoinColumn(name = "Chef_equipe")
	private UserEntity Chef_equipe;

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



	public List<EquipePersonnel> getEquipePersonnel() {
		return EquipePersonnel;
	}

	public void setEquipePersonnel(List<EquipePersonnel> equipePersonnel) {
		EquipePersonnel = equipePersonnel;
	}


	public UserEntity getChef_equipe() {
		return Chef_equipe;
	}

	public void setChef_equipe(UserEntity chef_equipe) {
		Chef_equipe = chef_equipe;
	}

	public Equipe() {
		super();
	}

	@Override
	public String toString() {
		return "Equipe [Id=" + Id + ", Nom=" + Nom + ", Chef_equipe=" + Chef_equipe + ", EquipePersonnel="
				+ EquipePersonnel + ", Taches=" + Taches + "]";
	}

	

}
