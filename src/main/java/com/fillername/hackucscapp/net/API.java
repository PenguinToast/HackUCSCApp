package com.fillername.hackucscapp.net;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fillername.hackucscapp.core.BeachData;
import com.fillername.hackucscapp.core.DataStore;
import com.fillername.hackucscapp.core.SunriseData;
import com.fillername.hackucscapp.core.TideData;

public class API {
	private static API instance;
	
	private CookieStore authCookies;
	private Document datsPage;

	private String username = "java.user.00001@gmail.com";
	private String password = "starcraft1";
	private String loginUrl = "http://www.surfline.com/myaccount/inc_login_handler.cfm";
	private String mainBeachUrl = "http://www.surfline.com/surf-forecasts/central-california/santa-cruz_2958";
	
	private boolean loginStatus;
	
	// instantiation is prevented
	private API() {}

	public static synchronized API get() {
		return (instance != null) ? instance : (instance = new API());
	}

	public void setCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public List<BeachData> getWeatherData() throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		List<BeachData> spotsDataList = new ArrayList<BeachData>(14);
		
		//HttpGet req = new H
    	/*for(int i = 0; i < DataStore.spotUrls.length; i++) {
    		String currSpotName = DataStore.spotUrls[i];
    		String suffix = currSpotName.substring(currSpotName.lastIndexOf('_')+1,currSpotName.length()-1);
    		Document doc = getJsoupDocFromUrl(currSpotName);
    		BeachData currData = null; 
    		System.out.println("@@@ GOT JSOUP DOC w/ TITLE: " + doc.text());
    		
    		Element forecast = doc.getElementById("forecast0");
    		Elements times = doc.select("div.spot-forecast.spot-forecast-time");
    		
    		for(int j = 0; j <= 3; j++) {
    			for(int k = 1; k <= 3; k++) {
    				String idSuffix = j + "-" + suffix + "-" + k;
    				System.out.println("spot-forecast-swell1-" + idSuffix);
    				System.out.println(doc.select("div#spot-forecast-swell1-" + idSuffix).html());
    				Element swell2 = doc.select("div#spot-forecast-swell2-" + idSuffix).first();
    				Element swell3 = doc.select("div#spot-forecast-swell3-" + idSuffix).first();
    				
    				//System.out.println(swell1 == null);
    				
    				//String str = swell1.select("span").select("strong").text();
    				int sw1ht = Integer.parseInt(str.substring(0, str.indexOf('f')));
    				str = swell2.select("span").select("strong").text();
    				int sw2ht = Integer.parseInt(str.substring(0, str.indexOf('f')));
    				str = swell3.select("span").select("strong").text();
    				int sw3ht = Integer.parseInt(str.substring(0, str.indexOf('f')));
    				
    				//System.out.println("@@@ " + sw1ht + " " + sw2ht + " " + sw3ht);
    				
    				//ArrayList<SwellData> swellDatas = new ArrayList<SwellData>();
    				//swellDatas.add(new SwellData());
    				//swellDatas.add(arg0);
    				//swellDatas.add(arg0);
        		}
    		}
    	}*/
    	
		return spotsDataList;
	}
	
	public List<TideData> getTideDatas() throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		Document doc = getJsoupDocFromUrl("http://www.tides.info/?command=view&location=Santa+Cruz,+Monterey+Bay,+California+(sub)");
		List<TideData> currData = new ArrayList<TideData>();
		
		Elements tides = doc.select("table[bgcolor=LIGHTGREY]").select("tr");
		for(int i = 1; i < 50; i++) {
			if(tides.get(i).select("td").first().text().trim().startsWith("Wed")) {
				break;
			}
			Elements tds = tides.get(i).select("td[align=right]");
			String d = tds.get(1).text().trim();
			String string = tds.get(0).text() + " " + d;
			
			if(d.contains("P"))
				string = tds.get(0).text() + " " + d.substring(0, d.indexOf('P')) + " PM";
			else if(d.contains("A"))
				string = tds.get(0).text() + " " + d.substring(0, d.indexOf('A')) + " AM";
			
			if(tds.size() < 3){
				continue;
			}
			
			try {
				Date date = new SimpleDateFormat("MM/dd/yy H:mm a", Locale.ENGLISH).parse(string);
				double feet = 0;
				String ft = tds.get(2).text();
				feet = Double.parseDouble(ft.substring(0, ft.indexOf(' ')));
				boolean isHighTide = tides.get(i).select("td").last().text().contains("H");
				//System.out.println(date.toString() + " @@ " + feet + " @@ " + isHighTide);
				
				TideData td = new TideData(date, feet, isHighTide);
				currData.add(td);
			} catch (ParseException e) {e.printStackTrace();}
		}
		
		System.out.println("TIDES: " + currData.size());
		System.out.println("@@@ GOT JSOUP DOC w/ TITLE: " + doc.text());
		
		for(TideData tide : currData) {
			System.out.println("!!!! " + tide.getHeight());
		}
		
		return currData;
	}
	
	public List<SunriseData> getSunrises() {
		HttpClient client = new DefaultHttpClient();
		Document doc = getJsoupDocFromUrl("http://www.tides.info/?command=view&location=Santa+Cruz,+Monterey+Bay,+California+(sub)");
		List<SunriseData> currData = new ArrayList<SunriseData>();
		Elements suns = doc.select("tr[bgcolor=white]");
		int idxs = 0;
		for(int i = 1; i < 50; i++) {
			if(suns.get(i).select("td").first().text().trim().startsWith("Wed")) {
				break;
			}
			Elements sns = suns.get(i).select("td[align=right]");
			String d = sns.get(1).text().trim();
			System.out.println("D: " + d);
			String string = sns.get(0).text() + " " + d;
			System.out.println("str: " + string);
			idxs++;
			
			if(d.contains("P"))
				string = sns.get(0).text() + " " + d.substring(0, d.indexOf('P')) + " PM";
			else if(d.contains("A"))
				string = sns.get(0).text() + " " + d.substring(0, d.indexOf('A')) + " AM";
			
			Date date = null;
			boolean isSunrise = false;
			try {
				String ss = suns.get(i).select("td[colspan=2]").text();
				if(ss.contains("First") || ss.contains("Moonset")) {
					System.out.println("skipping");
					idxs--;
					continue;
				}
				
				date = new SimpleDateFormat("MM/dd/yy H:mm a", Locale.ENGLISH).parse(string);
				isSunrise = ss.contains("Sunrise");
				if(ss.contains("Sunrise")) {
					isSunrise = true;
				} else if(ss.contains("Sunset")) {
					isSunrise = false;
				}
				
				System.out.println(date.toString() + " @@ " + isSunrise);
				
			} catch (ParseException e) {e.printStackTrace();}
			
			SunriseData td = new SunriseData(date, isSunrise);
			currData.add(td);
		}
		
		System.out.println("SUN: " + currData.size());
		/*for(SunriseData sun : currData) {
			System.out.println("!!!! " + sun.getSunriseOrSunset());
		}*/
		
		return currData;
	}
	
	private Document getJsoupDocFromUrl(String url) {
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
    	HttpResponse response = null;
    	try {
    		response = client.execute(httpGet);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	Document doc = null;
    	try {
    		doc = Jsoup.parse((InputStream) response.getEntity().getContent(), null, mainBeachUrl);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return doc;
	}
}
