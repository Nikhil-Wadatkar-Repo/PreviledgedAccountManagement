package com.sit.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "UserDetails")
@Entity
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@Column
	private String userName;
	@Column
	private String password;
	@Column
	private String role;
	@Column
	private String name;
	@Column
	private String enrolled;
	@Column
	private String statusLevelI;
	@Column
	private String statusLevelII;
	@Column
	private String statusLevelIII;
	@Column
	private String moduleName;

	public UserDetails() {
		// TODO Auto-generated constructor stub
	}



	



	public UserDetails(Integer userId, String userName, String password, String role, String name, String enrolled,
			String statusLevelI, String statusLevelII, String statusLevelIII, String moduleName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.name = name;
		this.enrolled = enrolled;
		this.statusLevelI = statusLevelI;
		this.statusLevelII = statusLevelII;
		this.statusLevelIII = statusLevelIII;
		this.moduleName = moduleName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}


	public String isEnrolled() {
		return enrolled;
	}

	public void setEnrolled(String enrolled) {
		this.enrolled = enrolled;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getStatusLevelI() {
		return statusLevelI;
	}

	public void setStatusLevelI(String statusLevelI) {
		this.statusLevelI = statusLevelI;
	}

	public String getStatusLevelII() {
		return statusLevelII;
	}

	public void setStatusLevelII(String statusLevelII) {
		this.statusLevelII = statusLevelII;
	}

	public String getStatusLevelIII() {
		return statusLevelIII;
	}

	public void setStatusLevelIII(String statusLevelIII) {
		this.statusLevelIII = statusLevelIII;
	}

	public String getEnrolled() {
		return enrolled;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", name=" + name + ", enrolled=" + enrolled + ", statusLevelI=" + statusLevelI + ", statusLevelII="
				+ statusLevelII + ", statusLevelIII=" + statusLevelIII + ", moduleName=" + moduleName + "]";
	}

}
