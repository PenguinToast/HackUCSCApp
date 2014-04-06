package com.fillername.hackucscapp.net;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.fillername.hackucscapp.core.BeachData;
import com.fillername.hackucscapp.core.DataStore;

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
			List<BeachData> spotsDataList = null;
			try {
				spotsDataList = API.get().getWeatherData();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			DataStore.setBeachDatas(spotsDataList);
			System.out.println("@@@ DONE REFRESHING");
			try {
				Thread.sleep(REFRESH_INTERVAL);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
