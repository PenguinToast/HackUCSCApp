package com.fillername.hackucscapp.net;

/**
 * This class refreshes the API information at regular intervals
 * to ensure weather/surf data stays updated.
 * @author Ajay Gopinath
 */
public class APIRefreshTask implements Runnable {
	private static final int REFRESH_INTERVAL = 1000;
	private String message;

	public APIRefreshTask() {
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(REFRESH_INTERVAL);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("HELLOWEIJO JOTJISOEJET");
		}
	}
}
