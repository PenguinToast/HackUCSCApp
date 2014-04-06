package com.fillername.hackucscapp.core;

import java.util.ArrayList;
import java.util.Date;

public class BeachRater {
	public static double rateBeach(CurrentBeachData current, IdealData ideal) {
		double rating = 0;
		
		double swellRating = 0;
		// Rate each swell
		for (SwellData swell : current.getSwells()) {
			if ()
		}
		rating += swellRating / (double) current.getSwells().size();
		
		// Rate tide based on closeness to changing
		
		
		return rating;
	}
	
	public static boolean inRange(double d, double min, double max) {
		return d >= min && d <= max;
	}
	
	public static class CurrentBeachData {
		private ArrayList<SwellData> swells;
		private Date time;
		
		public CurrentBeachData(Date time, ArrayList<SwellData> swells) {
			this.time = time;
			this.swells = swells;
		}
		
		public Date getTime() {
			return time;
		}
		
		public ArrayList<SwellData> getSwells() {
			return swells;
		}
	}
	
	public static class IdealData {
		private double minAngle, maxAngle;
		private double minSwell, maxSwell;
		private double minPeriod, maxPeriod;
		
		public IdealData(double minAngle, double maxAngle, double minSwell, double maxSwell, double minPeriod, double maxPeriod) {
			this.minAngle = minAngle;
			this.maxAngle = maxAngle;
			this.minSwell = minSwell;
			this.maxSwell = maxSwell;
			this.minPeriod = minPeriod;
			this.maxPeriod = maxPeriod;
		}
		public double getMinAngle() {
			return minAngle;
		}
		public double getMaxAngle() {
			return maxAngle;
		}
		public double getMinSwell() {
			return minSwell;
		}
		public double getMaxSwell() {
			return maxSwell;
		}
		public double getMinPeriod() {
			return minPeriod;
		}
		public double getMaxPeriod() {
			return maxPeriod;
		}
	}
}
