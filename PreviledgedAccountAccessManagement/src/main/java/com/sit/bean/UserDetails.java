package com.sit.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
//	@Column
//	private String role;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", referencedColumnName = "roleId")
	private RoleDetails role;
	
	@Column
	private String name;

//	@Column
//	private String enrolled;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "enrolled", referencedColumnName = "statusId")
	private StatusDetails enrolled;

//	@Column
//	private String moduleName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "modile_id", referencedColumnName = "moduleId")
	private ModuleDetails moduleDetails;

	@OneToOne(cascade = CascadeType.ALL)
	// used for bidirection one to one mapping
//	 @OneToOne(cascade = CascadeType.ALL, mappedBy = "details/", fetch = FetchType.LAZY)
	@JoinColumn(name = "status_Level_I", referencedColumnName = "statusId")
	private StatusDetails statusLevelI;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "status_Level_II", referencedColumnName = "statusId")
	private StatusDetails statusLevelII;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "status_Level_III", referencedColumnName = "statusId")
	private StatusDetails statusLevelIII;

	public UserDetails() {
		// TODO Auto-generated constructor stub
	}

	public UserDetails(Integer userId, String userName, String password, RoleDetails role, String name, StatusDetails enrolled,
			StatusDetails statusLevelI, StatusDetails statusLevelII, StatusDetails statusLevelIII) {
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

	}

//	public String getModuleName() {
//		return moduleName;
//	}
//
//	public void setModuleName(String moduleName) {
//		this.moduleName = moduleName;
//	}

	public StatusDetails isEnrolled() {
		return enrolled;
	}

	public void setEnrolled(StatusDetails enrolled) {
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

	public RoleDetails getRole() {
		return role;
	}

	public void setRole(RoleDetails role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StatusDetails getStatusLevelI() {
		return statusLevelI;
	}

	public void setStatusLevelI(StatusDetails statusLevelI) {
		this.statusLevelI = statusLevelI;
	}

	public StatusDetails getStatusLevelII() {
		return statusLevelII;
	}

	public void setStatusLevelII(StatusDetails statusLevelII) {
		this.statusLevelII = statusLevelII;
	}

	public StatusDetails getStatusLevelIII() {
		return statusLevelIII;
	}

	public void setStatusLevelIII(StatusDetails statusLevelIII) {
		this.statusLevelIII = statusLevelIII;
	}

	public StatusDetails getEnrolled() {
		return enrolled;
	}

	public ModuleDetails getModuleDetails() {
		return moduleDetails;
	}

	public void setModuleDetails(ModuleDetails moduleDetails) {
		this.moduleDetails = moduleDetails;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", name=" + name + ", enrolled=" + enrolled + ", statusLevelI=" + statusLevelI + ", statusLevelII="
				+ statusLevelII + ", statusLevelIII=" + statusLevelIII + ", moduleDetails=" + moduleDetails + "]";
	}

}
