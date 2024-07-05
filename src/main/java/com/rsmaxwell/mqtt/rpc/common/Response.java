package com.rsmaxwell.mqtt.rpc.common;

import java.net.HttpURLConnection;
import java.util.HashMap;

public class Response extends HashMap<String, Object> {

	public Response() {
		super();
	}

	public boolean ok() throws Exception {
		int code = getInteger("code");
		return (code == HttpURLConnection.HTTP_OK);
	}

	public Object putCode(int code) throws Exception {
		return put("code", code);
	}

	public int getCode() throws Exception {
		return getInteger("code");
	}

	public Object putMessage(String message) throws Exception {
		return put("code", message);
	}

	public String getMessage() throws Exception {
		return getString("message");
	}

	public String getString(String key) throws Exception {
		return Utilities.getString(this, key);
	}

	public Object put(String key, Object value) {
		return Utilities.put(this, key, value);
	}

	public Integer getInteger(String key) throws Exception {
		return Utilities.getInteger(this, key);
	}

	public Boolean getBoolean(String key) throws Exception {
		return Utilities.getBoolean(this, key);
	}
}
