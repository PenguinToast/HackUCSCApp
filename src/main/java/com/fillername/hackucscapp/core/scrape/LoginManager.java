package com.fillername.hackucscapp.core.scrape;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class LoginManager {
	private static final String USERNAME = "java.user.00001@gmail.com";
	private static final String PASSWORD = "starcraft1";
	private static final String USER_AGENT = "Mozilla/5.0";

	private static LoginManager INSTANCE;

	public static LoginManager getInstance() {
		return INSTANCE != null ? INSTANCE : new LoginManager();
	}

	private HttpClient client;
	private String cookies;

	private LoginManager() {
		client = HttpClientBuilder.create().build();
	}

	public void login() {
		CookieHandler.setDefault(new CookieManager());

		HttpPost post = new HttpPost("http://www.surfline.com/myaccount/inc_login_handler.cfm");
		// add header
		post.setHeader("Host", "www.surfline.com");
		post.setHeader("User-Agent", USER_AGENT);
		post.setHeader("Accept", "*/*");
		post.setHeader("Accept-Language", "en-US,en;q=0.5");
		post.setHeader("Cookie", getCookies());
		post.setHeader("Connection", "keep-alive");
		post.setHeader("Referer", "http://www.surfline.com/home/index.cfm");
		post.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		post.setHeader("Cache-Control", "no-cache");
		post.setHeader("Accept-Encoding", "gzip, deflate");
		post.setHeader("Pragma", "no-cache");

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", USERNAME));
		params.add(new BasicNameValuePair("password", PASSWORD));
		params.add(new BasicNameValuePair("rememberMe", "true"));

		try {
			post.setEntity(new UrlEncodedFormEntity(params));
			System.out.println(client.execute(post).getStatusLine().getStatusCode());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getCookies() {
		return cookies;
	}
}
