package com.fillername.hackucscapp.core;

public class MapData {

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
