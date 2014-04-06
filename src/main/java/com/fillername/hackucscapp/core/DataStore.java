package com.fillername.hackucscapp.core;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
	private static List<DetailsData> spotsDataList = new ArrayList<DetailsData>(14);
	private static List<TideData> tideList = new ArrayList<TideData>(14);
	private static List<SunriseData> sunriseList = new ArrayList<SunriseData>(14);
	
	public static String[] spotUrls = new String[] {
		"http://www.surfline.com/surf-forecasts/spot/waddell-creek_5021/",
		"http://www.surfline.com/surf-forecasts/spot/scott-creek_5022/",
		"http://www.surfline.com/surf-forecasts/spot/davenport_5024/",
		"http://www.surfline.com/surf-forecasts/spot/four-mile_5023/",
		"http://www.surfline.com/surf-forecasts/spot/natural-bridges_5027/",
		"http://www.surfline.com/surf-forecasts/spot/cowells_4189/"
	};
	
	public static List<DetailsData> getBeachDatas() {
		return spotsDataList;
	}
	
	public static void setBeachDatas(List<DetailsData> dats) {
		spotsDataList = dats;
	}

	public static List<SunriseData> getSunriseList() {
		return sunriseList;
	}

	public static void setSunriseList(List<SunriseData> sunriseList) {
		DataStore.sunriseList = sunriseList;
	}

	public static List<TideData> getTideList() {
		return tideList;
	}

	public static void setTideList(List<TideData> tideList) {
		DataStore.tideList = tideList;
	}
}
