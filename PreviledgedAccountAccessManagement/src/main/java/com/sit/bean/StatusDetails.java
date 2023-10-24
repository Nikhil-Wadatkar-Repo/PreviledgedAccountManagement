package com.sit.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "StatusDetails")
@Entity
public class StatusDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer statusId;

	@Column
	private String statusName;

	// used for bidirection one to one mapping
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_status_id", referencedColumnName = "userId")
//	private UserDetails details;

	public StatusDetails() {

	}

	public StatusDetails(Integer statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		return "StatusDetails [statusId=" + statusId + ", statusName=" + statusName + "]";
	}

}
