package com.fillername.hackucscapp.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fillername.hackucscapp.core.DetailsData;
import com.fillername.hackucscapp.core.MapData;
import com.fillername.hackucscapp.core.MapData.BeachMapData;
import com.fillername.hackucscapp.core.RecommendationsData;
import com.fillername.hackucscapp.core.RecommendationsData.BeachRecommendationData;

@Controller
public class JsonController {
	private static double testLat = 69.6969d;
	private static double testLong = 6969.69d;
	private static String testName = "Test Beach";
	private static int testId = 0;
	private static String testWeather = "Cloudy With a Chance of Meatballs";
	
	@RequestMapping("/api/recommendations")
	public @ResponseBody RecommendationsData recommendationsRequest() {
		RecommendationsData out = new RecommendationsData();
		BeachRecommendationData testBeach = new BeachRecommendationData(testId, testName, testLong, testLat);
		testBeach.setWeather(testWeather);
		out.getBeaches().add(testBeach);
		return out;
	}
	
	@RequestMapping("/api/map")
	public @ResponseBody MapData mapRequest() {
		MapData out = new MapData();
		BeachMapData testBeach = new BeachMapData(testId, testName, testLong, testLat);
		out.getBeaches().add(testBeach);
		return out;	
	}
	
	@RequestMapping("/api/details")
	public @ResponseBody DetailsData detailsRequest(
			@RequestParam(value="name", required=true) int id) {
		DetailsData out = new DetailsData(id, testName);
		out.setWeather(testWeather);
		out.setSwell("Wow Very Swell");
		out.setTemperature(9001);
		out.setSunrise(new Date());
		out.setSunrise(new Date());
		int numPoints = 4 * 7;
		for (int i = 0; i < numPoints; i++) {
			out.getTides().add(Math.sin(i));
			out.getRecommended().add(Math.sin(i) > 0 ? true : false);
		}
		return out;
	}

}
