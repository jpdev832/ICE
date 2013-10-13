package com.staticvillage.ice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class PresenceToken extends Token {
	@Expose private String accessToken;
	@Expose private String address;
	
	public PresenceToken(String accessToken, String address){
		this.accessToken = accessToken;
		this.address = address;
	}

	@Override
	public String getJsonString() {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(this);
	}
}
