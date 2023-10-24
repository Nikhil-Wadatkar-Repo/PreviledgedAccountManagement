package com.sit.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ModuleDetails")
@Entity
public class ModuleDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer moduleId;

	@Column
	private String moduleName;

	public ModuleDetails() {
		// TODO Auto-generated constructor stub
	}

	public ModuleDetails(Integer moduleId, String moduleName) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	@Override
	public String toString() {
		return "ModuleDetails [moduleId=" + moduleId + ", moduleName=" + moduleName + "]";
	}

}
