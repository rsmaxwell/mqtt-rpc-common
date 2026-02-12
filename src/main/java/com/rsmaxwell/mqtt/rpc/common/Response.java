package com.rsmaxwell.mqtt.rpc.common;

import java.net.HttpURLConnection;

import lombok.Data;

@Data
public class Response {

	private Status status;
	private Object payload;
	private boolean quit;

	public Response() {
	}

	public Response(Status status, Object payload) {
		this.status = status;
		this.payload = payload;
	}

	public boolean isOk() throws Exception {
		return (this.status.isOk());
	}

	public static Response success() {
		Response response = new Response();
		response.setStatus(new Status(HttpURLConnection.HTTP_OK, "Ok"));
		return response;
	}

	public static Response success(Object value) {
		Response response = new Response();
		response.setStatus(new Status(HttpURLConnection.HTTP_OK, "Ok"));
		response.setPayload(value);
		return response;
	}

	public static Response quit() {
		Response response = new Response();
		response.setStatus(new Status(HttpURLConnection.HTTP_OK, "Ok"));
		response.setQuit(true);
		return response;
	}

	public static Response response(int code, String message) {
		Response response = new Response();
		response.setStatus(new Status(code, message));
		return response;
	}

	// Common convenience methods

	public static Response badRequest(String message) {
		Response response = new Response();
		response.setStatus(new Status(HttpURLConnection.HTTP_BAD_REQUEST, message));
		return response;
	}

	public static Response internalError(String message) {
		Response response = new Response();
		response.setStatus(new Status(HttpURLConnection.HTTP_INTERNAL_ERROR, message));
		return response;
	}

	public static Response unauthorized() {
		Response response = new Response();
		response.setStatus(new Status(HttpURLConnection.HTTP_UNAUTHORIZED, "Unauthorized"));
		return response;
	}

	public static Response conflict(String message) {
		Response response = new Response();
		response.setStatus(new Status(HttpURLConnection.HTTP_CONFLICT, message));
		return response;
	}

	public static Response entityTooLarge(String message) {
		Response response = new Response();
		response.setStatus(new Status(HttpURLConnection.HTTP_ENTITY_TOO_LARGE, message));
		return response;
	}
}
