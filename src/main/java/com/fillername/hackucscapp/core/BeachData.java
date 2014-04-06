package com.fillername.hackucscapp.core;

/**
 * Base class for beach data, holds id and name
 */
public class BeachData {
	private final int id;
	private final String name;
	
	public BeachData(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
}
