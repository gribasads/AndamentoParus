package com.devsuperior.hrPayroll.entities;

import java.io.Serializable;

public class Payment implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private double dailyincome;
	private Integer days;
	
	public Payment() {
		
		
	}

	public Payment(String name, double dailyincome, Integer days) {
		super();
		this.name = name;
		dailyincome = dailyincome;
		this.days = days;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDailyincome() {
		return dailyincome;
	}

	public void setDailyincome(double dailyincome) {
		dailyincome = dailyincome;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}
	 public double getTotal() {
		 return days * dailyincome;
	 }
	

}
