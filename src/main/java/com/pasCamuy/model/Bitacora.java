package com.pasCamuy.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "bitacora")
public class Bitacora implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String report;
	
	@ManyToOne
	@JoinColumn(name ="operator_assistant_name_id")
	private OperatorAssistantName operatorAssistantName;
	
	@ManyToOne
	@JoinColumn(name = "work_shift_id")
	private WorkShift workShift;
	
	@ManyToOne
	@JoinColumn(name = "operator_name_id")
	private OperatorName operatorName;

	//*****************************
	//se puede utilizar LocalDate  como otro tipo de fecha y no habria que utilizar la anotacion @Temporal 
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "date")
//	NotNull
	private Date date;
	
	@OneToOne(mappedBy = "user")
	private User user;
	
	private static final long serialVersionUID = 1L;

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

	public OperatorAssistantName getOperatorAssistantName() {
		return operatorAssistantName;
	}

	public void setOperatorAssistantName(OperatorAssistantName operatorAssistantName) {
		this.operatorAssistantName = operatorAssistantName;
	}

	public WorkShift getWorkShift() {
		return workShift;
	}

	public void setWorkShift(WorkShift workShift) {
		this.workShift = workShift;
	}

	public OperatorName getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(OperatorName operatorName) {
		this.operatorName = operatorName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Bitacora [id=" + id + ", report=" + report + ", operatorAssistantName=" + operatorAssistantName
				+ ", workShift=" + workShift + ", operatorName=" + operatorName + ", date=" + date + ", user=" + user
				+ "]";
	}



	

}
