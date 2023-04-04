package com.pasCamuy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "bitacora")
public class Bitacora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String report;
	private String operatorAssistantName;
	private String operatorName;
	private String workShift;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "date")
//	NotNull
	private Date date;
	
	@OneToOne(mappedBy = "user")
	private User user;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Bitacora() {

	}

	public String getOperatorAssistantName() {
		return operatorAssistantName;
	}

	public void setOperatorAssistantName(String operatorAssistantName) {
		this.operatorAssistantName = operatorAssistantName;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getWorkShift() {
		return workShift;
	}

	public void setWorkShift(String workShift) {
		this.workShift = workShift;
	}

	@Override
	public String toString() {
		return "Bitacora [id=" + id + ", report=" + report + ", operatorAssistantName=" + operatorAssistantName
				+ ", operatorName=" + operatorName + ", workShift=" + workShift + ", date=" + date + "]";
	}

}
