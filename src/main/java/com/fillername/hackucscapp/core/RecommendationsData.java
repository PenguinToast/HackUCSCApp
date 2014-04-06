package com.fillername.hackucscapp.core;

/**
 * Data for the home screen, shows recommended beaches, distance, and time to go
 */
public class RecommendationsData {
	
	public static class BeachRecommendationData extends BeachData {
		private double longitude, latitude;
		
		
		public BeachRecommendationData(int id, String name) {
			super(id, name);
			
		}
		
	}
}
