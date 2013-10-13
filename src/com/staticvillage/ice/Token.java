package com.staticvillage.ice;

import com.google.gson.annotations.Expose;

public class Token {
	@Expose protected long uid;
	@Expose protected String namespace;
	
	public long getUid() {
		return uid;
	}
	protected void setUid(long uid) {
		this.uid = uid;
	}
	public String getNamespace() {
		return namespace;
	}
	protected void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
	public String getJsonString(){
		return null;
	}
	
	public byte[] getJsonBytes(){
		return null;
	}
}
