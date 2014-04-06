package com.fillername.hackucscapp.core;

import java.util.Date;

public class SunriseData {
	private Date sunriseOrSunset;
	private boolean isSunrise;
	
	public SunriseData(Date sunrise, boolean isSunrise) {
		this.sunriseOrSunset = sunrise;
		this.setSunrise(isSunrise);
	}
	
	public Date getSunriseOrSunset() {
		return sunriseOrSunset;
	}

	public void setSunriseOrSunset(Date sunriseOrSunset) {
		this.sunriseOrSunset = sunriseOrSunset;
	}

	public boolean isSunrise() {
		return isSunrise;
	}

	public void setSunrise(boolean isSunrise) {
		this.isSunrise = isSunrise;
	}
}
