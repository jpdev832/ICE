package com.staticvillage.ice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class RequestToken extends Token {
	@Expose private String[] compatible_namespaces;
	
	public RequestToken(long uid, String[] compatible_namespaces){
		this.uid = uid;
		this.compatible_namespaces = compatible_namespaces;
	}
	
	@Override
	public String getJsonString() {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(this);
	}
}
