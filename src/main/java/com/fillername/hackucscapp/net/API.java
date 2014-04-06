package com.fillername.hackucscapp.net;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.fillername.hackucscapp.core.BeachData;
import com.fillername.hackucscapp.core.DataStore;

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
    	for(int i = 0; i < DataStore.spotUrls.length; i++) {
    		String currSpotName = DataStore.spotUrls[i];
    		Document doc = getJsoupDocFromUrl(currSpotName);
    		System.out.println("@@@ GOT JSOUP DOC w/ TITLE: " + doc.title());
    		BeachData currData = null; 
    	}
    	
		return spotsDataList;
	}
	
	private Document getJsoupDocFromUrl(String url) {
		HttpClient client = new DefaultHttpClient();
		HttpPost httpGet = new HttpPost(url);
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
