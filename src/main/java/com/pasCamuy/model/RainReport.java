package com.pasCamuy.model;

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
@Table(name = "rainReport")
public class RainReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double inchesOfrain;
	private String hour;
	private String user;
	private String comment;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "date")
//	NotNull
	private Date date; 

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "RainReport [id=" + id + ", inchesOfrain=" + inchesOfrain + ", hour=" + hour + ", user=" + user
				+ ", comment=" + comment + ", date=" + date + "]";
	}
	
	




}
