package com.fillername.hackucscapp.core;

import java.util.ArrayList;

/**
 * Data for the home screen, shows recommended beaches, distance, and time to go
 */
public class RecommendationsData {
	private ArrayList<BeachRecommendationData> beaches;
	
	public RecommendationsData() {
		beaches = new ArrayList<>();
	}
	
	public ArrayList<BeachRecommendationData> getBeaches() {
		return beaches;
	}
	
	public static class BeachRecommendationData extends BeachData {
		private final double longitude, latitude;
		private String weather;
		private int temperature;
		
		public BeachRecommendationData(int id, String name, double longitude, double latitude) {
			super(id, name);
			this.longitude = longitude;
			this.latitude = latitude;
		}
		
		public double getLongitude() {
			return longitude;
		}
		
		public double getLatitude() {
			return latitude;
		}
		
		public String getWeather() {
			return weather;
		}
		
		public void setWeather(String weather) {
			this.weather = weather;
		}
		
		public int getTemperature() {
			return temperature;
		}
		
		public void setTemperature(int temperature) {
			this.temperature = temperature;
		}
		
	}
}
