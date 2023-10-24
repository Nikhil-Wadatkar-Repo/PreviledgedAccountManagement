package com.sit.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "RoleDetails")
@Entity
public class RoleDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roleId;

	@Column
	private String roleName;

	public RoleDetails() {
		// TODO Auto-generated constructor stub
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RoleDetails [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
