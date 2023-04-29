package com.pasCamuy.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operatorAssistantName")
public class OperatorAssistantName implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String operatorAssistantName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOperatorAssistantName() {
		return operatorAssistantName;
	}

	public void setOperatorAssistantName(String operatorAssistantName) {
		this.operatorAssistantName = operatorAssistantName;
	}

	@Override
	public String toString() {
		return "OperatorAssistantName [id=" + id + ", operatorAssistantName=" + operatorAssistantName + "]";
	}

}
