package com.tunisair.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_role_mapping database table.
 * 
 */
@Embeddable
public class UserRoleMappingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="role_id")
	private String roleId;

	@Column(name="user_id", insertable=false, updatable=false)
	private String userId;

	public UserRoleMappingPK() {
	}
	public String getRoleId() {
		return this.roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserRoleMappingPK)) {
			return false;
		}
		UserRoleMappingPK castOther = (UserRoleMappingPK)other;
		return 
			this.roleId.equals(castOther.roleId)
			&& this.userId.equals(castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.roleId.hashCode();
		hash = hash * prime + this.userId.hashCode();
		
		return hash;
	}
}