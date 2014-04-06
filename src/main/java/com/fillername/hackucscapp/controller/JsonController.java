package com.fillername.hackucscapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fillername.hackucscapp.core.DataStore;
import com.fillername.hackucscapp.core.DetailsData;
import com.fillername.hackucscapp.core.MapData;
import com.fillername.hackucscapp.core.MapData.BeachMapData;
import com.fillername.hackucscapp.core.RecommendationsData;
import com.fillername.hackucscapp.core.RecommendationsData.BeachRecommendationData;
import com.fillername.hackucscapp.core.SunriseData;
import com.fillername.hackucscapp.core.TideData;

@Controller
public class JsonController {
	private static double testLat = 69.6969d;
	private static double testLong = 6969.69d;
	private static String testName = "Test Beach";
	private static int testId = 0;
	private static String testWeather = "Slightly Cloudy";
	
	@RequestMapping("/api/recommendations")
	public @ResponseBody RecommendationsData recommendationsRequest() {
		RecommendationsData out = new RecommendationsData();
		BeachRecommendationData testBeach = new BeachRecommendationData(4188, "Steamer Lane", -122.024, 36.9539);
		testBeach.setWeather("Sunny");
		testBeach.setTemperature(70);
		BeachRecommendationData testBeach2 = new BeachRecommendationData(5022, "Scott Creek", -121.9, 37.467);
		testBeach.setWeather("Sunny");
		testBeach.setTemperature(66);
		BeachRecommendationData testBeach3 = new BeachRecommendationData(5024, "Davenport", -122.196, 37.0135);
		testBeach.setWeather("Sunny");
		testBeach.setTemperature(72);
		out.getBeaches().add(testBeach);
		out.getBeaches().add(testBeach2);
		out.getBeaches().add(testBeach3);
		return out;
	}
	
	@RequestMapping("/api/map")
	public @ResponseBody MapData mapRequest() {
		MapData out = new MapData();
		BeachMapData testBeach = new BeachMapData(4188, "Steamer Lane", -122.024, 36.9539);
		BeachMapData testBeach2 = new BeachMapData(5022, "Scott Creek", -121.9, 37.467);
		BeachMapData testBeach3 = new BeachMapData(5024, "Davenport", -122.196, 37.0135);
		out.getBeaches().add(testBeach);
		out.getBeaches().add(testBeach2);
		out.getBeaches().add(testBeach3);
		return out;	
	}
	
	@RequestMapping("/api/details")
	public @ResponseBody DetailsData detailsRequest(
			@RequestParam(value="id", required=true) int id) {
		
		DetailsData out = new DetailsData(id, testName);
		//out.setWeather(testWeather);
		
		List<TideData> t = DataStore.getTideList();
		for(int i = 0; i < t.size(); i++) {
			out.getTides().add(t.get(i).getHeight());
			System.out.println(t.get(i).getHeight());
		}
		
		List<SunriseData> s = DataStore.getSunriseList();
		for(int i = 0; i < s.size(); i++) {
			out.getSunrises().add(s.get(i).getSunriseOrSunset());
			System.out.println(s.get(i).getSunriseOrSunset());
		}
		
		return out;
	}
	
	@RequestMapping("/api/tides")
	public @ResponseBody List<TideData> tideDataRequest(
			@RequestParam(value="id", required=true) int id) {

		List<TideData> tideList = DataStore.getTideList();
		return tideList;
	}
	
	
	@RequestMapping("/api/suns")
	public @ResponseBody List<SunriseData> sunDataRequest(
			@RequestParam(value="id", required=true) int id) {
		
		List<SunriseData> sunList = DataStore.getSunriseList();
		return sunList;//out;
	}
}
