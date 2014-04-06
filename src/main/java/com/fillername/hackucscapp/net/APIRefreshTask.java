package com.fillername.hackucscapp.net;

import java.util.List;

import com.fillername.hackucscapp.core.DataStore;
import com.fillername.hackucscapp.core.DetailsData;

/**
 * This class refreshes the API information at regular intervals
 * to ensure weather/surf data stays updated.
 * @author Ajay Gopinath
 */
public class APIRefreshTask implements Runnable {
	private static final int REFRESH_INTERVAL = 60000;
	private String message;
	
	public APIRefreshTask() {}

	public void run() {
		while(true) {
			System.out.println("@@@ REFRESHING API DATA");
			List<DetailsData> spotsDataList = null;
			/*try {
				//spotsDataList = API.get().getWeatherData();
				//API.get().getTideDatas();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			
			DataStore.setBeachDatas(spotsDataList);
			System.out.println("@@@ DONE REFRESHING");
			try {
				API.get().getTideDatas();
				API.get().getSunrises();
				Thread.sleep(REFRESH_INTERVAL);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
