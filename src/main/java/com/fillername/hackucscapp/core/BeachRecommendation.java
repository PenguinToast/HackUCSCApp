package com.fillername.hackucscapp.core;

import java.util.Date;

public class BeachRecommendation {
	private Date date;
	private double rating;
	
	public BeachRecommendation(Date date, double rating) {
		this.date = date;
		this.rating = rating;
	}
	
	public Date getDate() {
		return date;
	}
	
	public double getRating() {
		return rating;
	}
}
