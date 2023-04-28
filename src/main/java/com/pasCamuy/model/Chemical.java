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
@Table(name="chemical")
public class Chemical {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private  double chlorineReadingYesterday1;
	private  double chlorineReadingToday1;
	private double chlorineConsumption1;
	
	private  double chlorineReadingYesterday2;
	private  double chlorineReadingToday2;
	private double chlorineConsumption2;
	
	private double bisulfiteReadingYesterday;
	private double bisulfiteReadingToday;
	private double bisulfiteConsumption;
	
	private double ferricReadingYesterday;
	private double ferricReadingToday;
	private double ferricConsumption;
	
	private double causticSodaReadingYesterday;
	private double causticSodaReadingToday;
	private double causticConsumption;
	
	private double dieselReadingYesterday;
	private double dieselReadingToday;
	private double dieselConsumption;
	
	private double hthReadingYesterday;
	private double hthReadingToday;
	private double hthConsumption;
	
	private int fullCylinders;
	private int emptyCylinders;
	private int cylindersInUse;
	
	private double flowTotalizerYesterday;
	private double flowTotalizerToday;
	private double totalFlow;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "dateYesterday")
	private Date dateYesterday;
	
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "dateToday")
	private Date dateToday;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getChlorineReadingYesterday1() {
		return chlorineReadingYesterday1;
	}
	public void setChlorineReadingYesterday1(double chlorineReadingYesterday1) {
		this.chlorineReadingYesterday1 = chlorineReadingYesterday1;
	}
	public double getChlorineReadingToday1() {
		return chlorineReadingToday1;
	}
	public void setChlorineReadingToday1(double chlorineReadingToday1) {
		this.chlorineReadingToday1 = chlorineReadingToday1;
	}
	public double getChlorineConsumption1() {
		return chlorineConsumption1;
	}
	public void setChlorineConsumption1(double chlorineConsumption1) {
		this.chlorineConsumption1 = chlorineConsumption1;
	}
	public double getChlorineReadingYesterday2() {
		return chlorineReadingYesterday2;
	}
	public void setChlorineReadingYesterday2(double chlorineReadingYesterday2) {
		this.chlorineReadingYesterday2 = chlorineReadingYesterday2;
	}
	public double getChlorineReadingToday2() {
		return chlorineReadingToday2;
	}
	public void setChlorineReadingToday2(double chlorineReadingToday2) {
		this.chlorineReadingToday2 = chlorineReadingToday2;
	}
	public double getChlorineConsumption2() {
		return chlorineConsumption2;
	}
	public void setChlorineConsumption2(double chlorineConsumption2) {
		this.chlorineConsumption2 = chlorineConsumption2;
	}
	public double getBisulfiteReadingYesterday() {
		return bisulfiteReadingYesterday;
	}
	public void setBisulfiteReadingYesterday(double bisulfiteReadingYesterday) {
		this.bisulfiteReadingYesterday = bisulfiteReadingYesterday;
	}
	public double getBisulfiteReadingToday() {
		return bisulfiteReadingToday;
	}
	public void setBisulfiteReadingToday(double bisulfiteReadingToday) {
		this.bisulfiteReadingToday = bisulfiteReadingToday;
	}
	public double getBisulfiteConsumption() {
		return bisulfiteConsumption;
	}
	public void setBisulfiteConsumption(double bisulfiteConsumption) {
		this.bisulfiteConsumption = bisulfiteConsumption;
	}
	public double getFerricReadingYesterday() {
		return ferricReadingYesterday;
	}
	public void setFerricReadingYesterday(double ferricReadingYesterday) {
		this.ferricReadingYesterday = ferricReadingYesterday;
	}
	public double getFerricReadingToday() {
		return ferricReadingToday;
	}
	public void setFerricReadingToday(double ferricReadingToday) {
		this.ferricReadingToday = ferricReadingToday;
	}
	public double getFerricConsumption() {
		return ferricConsumption;
	}
	public void setFerricConsumption(double ferricConsumption) {
		this.ferricConsumption = ferricConsumption;
	}
	public double getCausticSodaReadingYesterday() {
		return causticSodaReadingYesterday;
	}
	public void setCausticSodaReadingYesterday(double causticSodaReadingYesterday) {
		this.causticSodaReadingYesterday = causticSodaReadingYesterday;
	}
	public double getCausticSodaReadingToday() {
		return causticSodaReadingToday;
	}
	public void setCausticSodaReadingToday(double causticSodaReadingToday) {
		this.causticSodaReadingToday = causticSodaReadingToday;
	}
	public double getCausticConsumption() {
		return causticConsumption;
	}
	public void setCausticConsumption(double causticConsumption) {
		this.causticConsumption = causticConsumption;
	}
	public double getDieselReadingYesterday() {
		return dieselReadingYesterday;
	}
	public void setDieselReadingYesterday(double dieselReadingYesterday) {
		this.dieselReadingYesterday = dieselReadingYesterday;
	}
	public double getDieselReadingToday() {
		return dieselReadingToday;
	}
	public void setDieselReadingToday(double dieselReadingToday) {
		this.dieselReadingToday = dieselReadingToday;
	}
	public double getDieselConsumption() {
		return dieselConsumption;
	}
	public void setDieselConsumption(double dieselConsumption) {
		this.dieselConsumption = dieselConsumption;
	}
	public double getHthReadingYesterday() {
		return hthReadingYesterday;
	}
	public void setHthReadingYesterday(double hthReadingYesterday) {
		this.hthReadingYesterday = hthReadingYesterday;
	}
	public double getHthReadingToday() {
		return hthReadingToday;
	}
	public void setHthReadingToday(double hthReadingToday) {
		this.hthReadingToday = hthReadingToday;
	}
	public double getHthConsumption() {
		return hthConsumption;
	}
	public void setHthConsumption(double hthConsumption) {
		this.hthConsumption = hthConsumption;
	}
	
	public int getFullCylinders() {
		return fullCylinders;
	}
	public void setFullCylinders(int fullCylinders) {
		this.fullCylinders = fullCylinders;
	}
	public int getEmptyCylinders() {
		return emptyCylinders;
	}
	public void setEmptyCylinders(int emptyCylinders) {
		this.emptyCylinders = emptyCylinders;
	}
	public int getCylindersInUse() {
		return cylindersInUse;
	}
	public void setCylindersInUse(int cylindersInUse) {
		this.cylindersInUse = cylindersInUse;
	}
	
	public Date getDateYesterday() {
		return dateYesterday;
	}
	public void setDateYesterday(Date dateYesterday) {
		this.dateYesterday = dateYesterday;
	}
	public Date getDateToday() {
		return dateToday;
	}
	public void setDateToday(Date dateToday) {
		this.dateToday = dateToday;
	}
	
	public double getFlowTotalizerYesterday() {
		return flowTotalizerYesterday;
	}
	public void setFlowTotalizerYesterday(double flowTotalizerYesterday) {
		this.flowTotalizerYesterday = flowTotalizerYesterday;
	}
	public double getFlowTotalizerToday() {
		return flowTotalizerToday;
	}
	public void setFlowTotalizerToday(double flowTotalizerToday) {
		this.flowTotalizerToday = flowTotalizerToday;
	}
	public double getTotalFlow() {
		return totalFlow;
	}
	public void setTotalFlow(double totalFlow) {
		this.totalFlow = totalFlow;
	}
	@Override
	public String toString() {
		return "Chemical [id=" + id + ", chlorineReadingYesterday1=" + chlorineReadingYesterday1
				+ ", chlorineReadingToday1=" + chlorineReadingToday1 + ", chlorineConsumption1=" + chlorineConsumption1
				+ ", chlorineReadingYesterday2=" + chlorineReadingYesterday2 + ", chlorineReadingToday2="
				+ chlorineReadingToday2 + ", chlorineConsumption2=" + chlorineConsumption2
				+ ", bisulfiteReadingYesterday=" + bisulfiteReadingYesterday + ", bisulfiteReadingToday="
				+ bisulfiteReadingToday + ", bisulfiteConsumption=" + bisulfiteConsumption + ", ferricReadingYesterday="
				+ ferricReadingYesterday + ", ferricReadingToday=" + ferricReadingToday + ", ferricConsumption="
				+ ferricConsumption + ", causticSodaReadingYesterday=" + causticSodaReadingYesterday
				+ ", causticSodaReadingToday=" + causticSodaReadingToday + ", causticConsumption=" + causticConsumption
				+ ", dieselReadingYesterday=" + dieselReadingYesterday + ", dieselReadingToday=" + dieselReadingToday
				+ ", dieselConsumption=" + dieselConsumption + ", hthReadingYesterday=" + hthReadingYesterday
				+ ", hthReadingToday=" + hthReadingToday + ", hthConsumption=" + hthConsumption + ", fullCylinders="
				+ fullCylinders + ", emptyCylinders=" + emptyCylinders + ", cylindersInUse=" + cylindersInUse
				+ ", flowTotalizerYesterday=" + flowTotalizerYesterday + ", flowTotalizerToday=" + flowTotalizerToday
				+ ", totalFlow=" + totalFlow + ", dateYesterday=" + dateYesterday + ", dateToday=" + dateToday + "]";
	}
	
	


	
	
	

	
	
	
	

}
