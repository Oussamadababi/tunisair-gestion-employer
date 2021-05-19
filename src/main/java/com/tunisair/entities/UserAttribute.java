package com.tunisair.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the user_attribute database table.
 * 
 */
@Entity
@Table(name="user_attribute")
@NamedQuery(name="UserAttribute.findAll", query="SELECT u FROM UserAttribute u")
public class UserAttribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	private String value;

	//bi-directional many-to-one association to UserEntity
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="user_id")
	private UserEntity userEntity;

	public UserAttribute() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public UserEntity getUserEntity() {
		return this.userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

}