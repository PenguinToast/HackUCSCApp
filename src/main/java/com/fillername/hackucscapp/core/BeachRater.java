package com.fillername.hackucscapp.core;

import java.util.Calendar;
import java.util.Date;


public class BeachRater {
	public static final double angleWeight = 1,
			heightWeight = 1,
			periodWeight = 1;
	
	@SuppressWarnings("deprecation")
	public static BeachRecommendation getRecommendation(DetailsData beach, IdealData ideal) {
		int bestTime = 0;
		double bestRating = Double.MIN_VALUE;
		for (int i = 0; i < beach.getSwellTimes().size(); i++) {
			double rating = rateBeach(beach, ideal, i);
			if (rating > bestRating) {
				bestRating = rating;
				bestTime = i;
			}
		}
		
		Date date = new Date();
		date.setMinutes(0);
		date.setSeconds(0);
		date.setHours(5 + bestTime * 6);
		
		return new BeachRecommendation(date, bestRating);
	}
	
	public static double rateBeach(DetailsData current, IdealData ideal, int time) {
		double rating = 0;
		
		double swellRating = 0;
		double numSwells = 0;
		// Rate each swell
		for (int i = time * 3; i < time * 3 + 3; i++) {
			SwellData swell = current.getSwells().get(i);
			if (swell != null) {
				numSwells++;
				if (inRange(swell.angle, ideal.minAngle, ideal.maxAngle)) {
					swellRating += angleWeight;
				} else {
					swellRating -= angleWeight;
				}
				if (inRange(swell.height, ideal.minSwell, ideal.maxSwell)) {
					swellRating += heightWeight;
				} else {
					swellRating -= heightWeight;
				}
				if (inRange(swell.period, ideal.minPeriod, ideal.maxPeriod)) {
					swellRating += periodWeight;
				} else {
					swellRating -= periodWeight;
				}
				
			}
		}
		rating += swellRating / numSwells;
		
		// Rate tide based on closeness to changing
		
		
		return rating;
	}
	
	public static boolean inRange(double d, double min, double max) {
		return d >= min && d <= max;
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
