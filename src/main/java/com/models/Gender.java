package com.models;

public enum Gender {
	
	MALE("M"),FEMALE("F");
	
	
	private String c;

	Gender(String c){
		this.c=c;
	}
	
	public String getType() {
		return c;
	}
}
