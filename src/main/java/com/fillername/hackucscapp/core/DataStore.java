package com.fillername.hackucscapp.core;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
	private static List<BeachData> spotsDataList = new ArrayList<BeachData>(14);
	public static String[] spotUrls = new String[] {
		"http://www.surfline.com/surf-forecasts/spot/waddell-creek_5021/",
		"http://www.surfline.com/surf-forecasts/spot/scott-creek_5022/",
		"http://www.surfline.com/surf-forecasts/spot/davenport_5024/",
		"http://www.surfline.com/surf-forecasts/spot/four-mile_5023/",
		"http://www.surfline.com/surf-forecasts/spot/natural-bridges_5027/",
		"http://www.surfline.com/surf-forecasts/spot/cowells_4189/"
	};
	
	public static List<BeachData> getBeachDatas() {
		return spotsDataList;
	}
	
	public static void setBeachDatas(List<BeachData> dats) {
		spotsDataList = dats;
	}
}
