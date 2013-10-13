package com.staticvillage.ice;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.Expose;

public class ResponseToken extends Token {
	@Expose private float influence;
	@Expose private String payload;
	@Expose private long timestamp;
	@Expose private long srcTimestamp;
	
	public ResponseToken(long uid, String namespace){
		this(uid, namespace, 0.5f);
	}
	public ResponseToken(long uid, String namespace, float influence){
		this.uid = uid;
		this.namespace = namespace;
		influence = 0.5f;
		payload = "{}";
		timestamp = new Date().getTime();
		srcTimestamp = 0L;
	}
	
	public float getInfluence() {
		return influence;
	}
	public void setInfluence(float influence) {
		this.influence = influence;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) throws Exception {
		if(!QualifiedPayload(payload))
			throw new Exception("Invaild payload");
		
		this.payload = payload;
	}
	public long getSrcTimestamp() {
		return srcTimestamp;
	}
	public void setSrcTimestamp(long srcTimestamp) {
		this.srcTimestamp = srcTimestamp;
	}
	public long getTimestamp() {
		return timestamp;
	}
	
	@Override
	public String getJsonString() {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(this);
	}
	
	private boolean QualifiedPayload(String payload){
		try{
			new JsonParser().parse(payload);
		}catch(JsonSyntaxException e){
			return false;
		}	
		return true;
	}
}
