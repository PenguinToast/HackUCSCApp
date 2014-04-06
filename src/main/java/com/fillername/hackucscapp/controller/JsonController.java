package com.fillername.hackucscapp.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fillername.hackucscapp.core.BeachData;
import com.fillername.hackucscapp.core.DetailsData;
import com.fillername.hackucscapp.core.MapData;
import com.fillername.hackucscapp.core.MapData.BeachMapData;
import com.fillername.hackucscapp.core.RecommendationsData;
import com.fillername.hackucscapp.core.RecommendationsData.BeachRecommendationData;
import com.fillername.hackucscapp.net.API;

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
		out.setWeather(testWeather);
		//out.setSwell("Wow Very Swell");
		out.setTemperature(9001);
		out.setSunrise(new Date());
		out.setSunset(new Date());
		int numPoints = 4 * 7;
		for (int i = 0; i < numPoints; i++) {
			out.getTides().add(Math.sin(i));
			out.getRecommended().add(Math.sin(i) > 0 ? true : false);
		}
		return out;
	}
	
	@RequestMapping("/api/realDetails")
	public @ResponseBody DetailsData realDetailsRequest(
			@RequestParam(value="id", required=true) int id) {
		try {
			List<BeachData> weatherDats = API.get().getWeatherData();
			System.out.println("GOT DATS");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//DetailsData out = new DetailsData(id, testName);
		//out.setWeather(testWeather);
		//out.setSwell("Wow Very Swell");
		///out.setTemperature(9001);
		//out.setSunrise(new Date());
		//out.setSunrise(new Date());
		//int numPoints = 4 * 7;
		//for (int i = 0; i < numPoints; i++) {
		//	out.getTides().add(Math.sin(i));
		//	out.getRecommended().add(Math.sin(i) > 0 ? true : false);
		//}
		return null;//out;
	}
}
