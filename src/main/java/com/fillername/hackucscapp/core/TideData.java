package com.fillername.hackucscapp.core;

import java.util.Date;

public class TideData {
	private Date time;
	private double height;
	private boolean isHighTide;
	
	public TideData(Date time, double height, boolean isHighTide) {
		this.time = time;
		this.height = height;
		this.isHighTide = isHighTide;
	}
	
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public boolean isHighTide() {
		return isHighTide;
	}

	public void setHighTide(boolean isHighTide) {
		this.isHighTide = isHighTide;
	}
}
