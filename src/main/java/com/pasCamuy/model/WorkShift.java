package com.pasCamuy.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "workshift")
public class WorkShift implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String workshift;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkshift() {
		return workshift;
	}

	public void setWorkshift(String workshift) {
		this.workshift = workshift;
	}

	@Override
	public String toString() {
		return "WorkShift [id=" + id + ", workshift=" + workshift + "]";
	}

	public WorkShift() {

	}

}
