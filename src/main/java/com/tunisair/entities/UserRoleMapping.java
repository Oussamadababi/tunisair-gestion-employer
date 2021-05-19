package com.tunisair.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_role_mapping database table.
 * 
 */
@Entity
@Table(name="user_role_mapping")
@NamedQuery(name="UserRoleMapping.findAll", query="SELECT u FROM UserRoleMapping u")
public class UserRoleMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserRoleMappingPK id;

	public UserRoleMapping() {
	}

	public UserRoleMappingPK getId() {
		return this.id;
	}

	public void setId(UserRoleMappingPK id) {
		this.id = id;
	}

}