package com.pasCamuy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rainReport")
public class RainReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double inchesOfrain;
	private String hour;
	private String user;
	private String comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getInchesOfrain() {
		return inchesOfrain;
	}

	public void setInchesOfrain(double inchesOfrain) {
		this.inchesOfrain = inchesOfrain;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "RainReport [id=" + id + ", inchesOfrain=" + inchesOfrain + ", hour=" + hour + ", user=" + user
				+ ", comment=" + comment + "]";
	}



}
