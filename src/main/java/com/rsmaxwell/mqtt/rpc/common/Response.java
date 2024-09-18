package com.rsmaxwell.mqtt.rpc.common;

import java.net.HttpURLConnection;
import java.util.HashMap;

public class Response extends HashMap<String, Object> {

	public Response() {
		super();
	}

	public boolean isok() throws Exception {
		int code = getInteger("code");
		return (code == HttpURLConnection.HTTP_OK);
	}

	public static Response success() {
		Response response = new Response();
		response.put("code", HttpURLConnection.HTTP_OK);
		return response;
	}

	public static Response success(Object value) {
		Response response = new Response();
		response.put("code", HttpURLConnection.HTTP_OK);
		response.put("result", value);
		return response;
	}

	public static Response quit() {
		Response response = new Response();
		response.put("code", HttpURLConnection.HTTP_OK);
		return response;
	}

	public static Response badRequest(String message) {
		Response response = new Response();
		response.put("code", HttpURLConnection.HTTP_BAD_REQUEST);
		response.put("message", message);
		return response;
	}

	public static Response internalError(String message) {
		Response response = new Response();
		response.put("code", HttpURLConnection.HTTP_INTERNAL_ERROR);
		response.put("message", message);
		return response;
	}

	public static Response unauthorized(String message) {
		Response response = new Response();
		response.put("code", HttpURLConnection.HTTP_UNAUTHORIZED);
		response.put("message", message);
		return response;
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

	public Integer getInteger(String key) throws Exception {
		return Utilities.getInteger(this, key);
	}

	public Long getLong(String key) throws Exception {
		return Utilities.getLong(this, key);
	}

	public Boolean getBoolean(String key) throws Exception {
		return Utilities.getBoolean(this, key);
	}
}
