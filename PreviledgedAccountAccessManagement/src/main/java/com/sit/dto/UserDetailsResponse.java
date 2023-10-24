package com.sit.dto;

public class UserDetailsResponse {
	private Integer userId;
	private String moduleName;

	private String userName;

	private String password;

	private String role;

	private String name;

	private String enrolled;

	private String statusLevelI;

	private String statusLevelII;

	private String statusLevelIII;

	public UserDetailsResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getModuleName() {
		return moduleName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setModuleName(String moduleId) {
		this.moduleName = moduleId;
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

	public String getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(String enrolled) {
		this.enrolled = enrolled;
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

	@Override
	public String toString() {
		return "UserDetailsResponse [moduleId=" + moduleName + ", userName=" + userName + ", password=" + password
				+ ", role=" + role + ", name=" + name + ", enrolled=" + enrolled + ", statusLevelI=" + statusLevelI
				+ ", statusLevelII=" + statusLevelII + ", statusLevelIII=" + statusLevelIII + "]";
	}

}
