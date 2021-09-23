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
public class Qualification_details implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private Date  date_reussite;
	private Date  date_fin;
	// Relation avec entité formation et personnel (Porteuse de données)
		@ManyToOne
		@JoinColumn(name = "idP")
		private UserEntity personnel;
		@ManyToOne
		@JoinColumn(name = "idQ")
		private Qualification qualification;
		public long getId() {
			return Id;
		}
		public void setId(long id) {
			Id = id;
		}
		public Date getDate_reussite() {
			return date_reussite;
		}
		public void setDate_reussite(Date date_reussite) {
			this.date_reussite = date_reussite;
		}
		public Date getDate_fin() {
			return date_fin;
		}
		public void setDate_fin(Date date_fin) {
			this.date_fin = date_fin;
		}
		public UserEntity getPersonnel() {
			return personnel;
		}
		public void setPersonnel(UserEntity personnel) {
			this.personnel = personnel;
		}
		public Qualification getQualification() {
			return qualification;
		}
		public void setQualification(Qualification qualification) {
			this.qualification = qualification;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public Qualification_details(long id, Date date_reussite, Date date_fin, UserEntity personnel,
				Qualification qualification) {
			super();
			Id = id;
			this.date_reussite = date_reussite;
			this.date_fin = date_fin;
			this.personnel = personnel;
			this.qualification = qualification;
		}
		public Qualification_details() {
			super();
		}
		public Qualification_details(Date date_reussite, Date date_fin, UserEntity personnel,
				Qualification qualification) {
			super();
			this.date_reussite = date_reussite;
			this.date_fin = date_fin;
			this.personnel = personnel;
			this.qualification = qualification;
		}

		
}
