package com.qa.util;

import com.google.gson.Gson;

public class JSONUtility {
	
	private Gson jgson;
	
	public JSONUtility() {
		this.jgson = new Gson();
	}
	
	public String getJGsonForObject(Object aObj) {
		return jgson.toJson(aObj);
	}
	
	public <T> T getObjectForJGson(String jgsonStr, Class<T> theClass) {
		return jgson.fromJson(jgsonStr, theClass);
	}

}
