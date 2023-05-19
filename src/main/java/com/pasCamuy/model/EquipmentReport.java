package com.pasCamuy.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "equipmentReport")
public class EquipmentReport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String equipmentDescription;
	private String location;
	private long sapNumber;
	private long equipmentIdentificationNumber;
	private String status;
	private String user;
	private String image;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "lastMaintenance")
	private Date lastMaintenance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEquipmentDescription() {
		return equipmentDescription;
	}

	public void setEquipmentDescription(String equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getSapNumber() {
		return sapNumber;
	}

	public void setSapNumber(long sapNumber) {
		this.sapNumber = sapNumber;
	}

	public long getEquipmentIdentificationNumber() {
		return equipmentIdentificationNumber;
	}

	public void setEquipmentIdentificationNumber(long equipmentIdentificationNumber) {
		this.equipmentIdentificationNumber = equipmentIdentificationNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getLastMaintenance() {
		return lastMaintenance;
	}

	public void setLastMaintenance(Date lastMaintenance) {
		this.lastMaintenance = lastMaintenance;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "EquipmentReport [id=" + id + ", name=" + name + ", equipmentDescription=" + equipmentDescription
				+ ", location=" + location + ", sapNumber=" + sapNumber + ", equipmentIdentificationNumber="
				+ equipmentIdentificationNumber + ", status=" + status + ", user=" + user + ", image=" + image
				+ ", lastMaintenance=" + lastMaintenance + "]";
	}



	




}
