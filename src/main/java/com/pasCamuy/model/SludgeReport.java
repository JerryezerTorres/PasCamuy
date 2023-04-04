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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sludeReport")
public class SludgeReport implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cp101;
	private String cp102;
	private String ci101;
	private String ci102;
	private String cf101;
	private String cf102;
	private String htLevel;
	private String comment;
	
	private String hour;
	private String user;
	
//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(iso = ISO.DATE)
//	@Column(name = "date")
//	private Date date;
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCp101() {
		return cp101;
	}

	public void setCp101(String cp101) {
		this.cp101 = cp101;
	}

	public String getCp102() {
		return cp102;
	}

	public void setCp102(String cp102) {
		this.cp102 = cp102;
	}

	public String getCi101() {
		return ci101;
	}

	public void setCi101(String ci101) {
		this.ci101 = ci101;
	}

	public String getCi102() {
		return ci102;
	}

	public void setCi102(String ci102) {
		this.ci102 = ci102;
	}

	public String getCf101() {
		return cf101;
	}

	public void setCf101(String cf101) {
		this.cf101 = cf101;
	}

	public String getCf102() {
		return cf102;
	}

	public void setCf102(String cf102) {
		this.cf102 = cf102;
	}

	public String getHtLevel() {
		return htLevel;
	}

	public void setHtLevel(String htLevel) {
		this.htLevel = htLevel;
	}

//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}

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

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		return "SludgeReport [id=" + id + ", cp101=" + cp101 + ", cp102=" + cp102 + ", ci101=" + ci101 + ", ci102="
				+ ci102 + ", cf101=" + cf101 + ", cf102=" + cf102 + ", htLevel=" + htLevel + ", comment=" + comment
				+ ", hour=" + hour + ", user=" + user + "]";
	}
	
	public SludgeReport() {
		
	}





}
