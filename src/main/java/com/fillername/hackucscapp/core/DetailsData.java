package com.fillername.hackucscapp.core;

import java.util.ArrayList;
import java.util.Date;

/**
 * Detailed data of a beach, including forecasts and recommended times
 */
public class DetailsData extends BeachData {
	private int temperature;
	private String weather;
	private ArrayList<SwellData> swells;
	private ArrayList<String> swellTimes;
	
	private Date sunrise, sunset;
	private ArrayList<Double> tides;
	private ArrayList<Date> sunrises;
	private ArrayList<Boolean> recommended;
	
	public DetailsData(int id, String name) {
		super(id, name);
		
		tides = new ArrayList<>();
		recommended = new ArrayList<>();
		sunrises = new ArrayList<Date>();
		tides = new ArrayList<Double>();
	}
	
	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public Date getSunrise() {
		return sunrise;
	}

	public void setSunrise(Date sunrise) {
		this.sunrise = sunrise;
	}

	public Date getSunset() {
		return sunset;
	}

	public void setSunset(Date sunset) {
		this.sunset = sunset;
	}

	public ArrayList<Double> getTides() {
		return tides;
	}
	
	public void setTides(ArrayList<Double> t) {
		tides = t;
	}

	public ArrayList<Boolean> getRecommended() {
		return recommended;
	}
	
	public ArrayList<String> getSwellTimes() {
		return swellTimes;
	}

	public void setSwellTimes(ArrayList<String> swellTimes) {
		this.swellTimes = swellTimes;
	}

	public ArrayList<Date> getSunrises() {
		return sunrises;
	}

	public void setSunrises(ArrayList<Date> sunrises) {
		this.sunrises = sunrises;
	}
	
	public ArrayList<SwellData> getSwells() {
		return swells;
	}
}
