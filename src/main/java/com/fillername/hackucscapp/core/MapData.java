package com.fillername.hackucscapp.core;

import java.util.ArrayList;

/**
 * Data for the map screen in order to display points on Google Maps
 */
public class MapData {
	private final ArrayList<BeachMapData> beaches;
	
	public MapData() {
		beaches = new ArrayList<>();
	}
	
	public ArrayList<BeachMapData> getBeaches() {
		return beaches;
	}

	public static class BeachMapData extends BeachData {
		private final double longitude;
		private final double latitude;

		public BeachMapData(int id, String name, double longitude, double latitude) {
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
	}
}
