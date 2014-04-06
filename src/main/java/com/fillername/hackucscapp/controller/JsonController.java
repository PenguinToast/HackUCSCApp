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
		BeachRecommendationData testBeach = new BeachRecommendationData(testId, testName, testLong, testLat);
		testBeach.setWeather(testWeather);
		testBeach.setTemperature(9001);
		out.getBeaches().add(testBeach);
		out.getBeaches().add(testBeach);
		out.getBeaches().add(testBeach);
		return out;
	}
	
	@RequestMapping("/api/map")
	public @ResponseBody MapData mapRequest() {
		MapData out = new MapData();
		BeachMapData testBeach = new BeachMapData(testId, testName, testLong, testLat);
		BeachMapData testBeach2 = new BeachMapData(testId, testName, testLong - 70, testLat);
		out.getBeaches().add(testBeach);
		out.getBeaches().add(testBeach2);
		return out;	
	}
	
	@RequestMapping("/api/details")
	public @ResponseBody DetailsData detailsRequest(
			@RequestParam(value="id", required=true) int id) {
		
		DetailsData out = new DetailsData(id, testName);
		//out.setWeather(testWeather);
		
		List<TideData> t = DataStore.getTideList();
		for(int i = 0; i < t.size(); i++) {
			out.getTides().set(i, t.get(i).getHeight());
			System.out.println(t.get(i).getHeight());
		}
		
		List<SunriseData> s = DataStore.getSunriseList();
		for(int i = 0; i < s.size(); i++) {
			out.getSunrises().set(i, s.get(i).getSunriseOrSunset());
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
