package com.rsmaxwell.mqtt.rpc.common;

import java.net.HttpURLConnection;

public class Result {

	private Response response;
	private boolean quit;

	public static Result ok() {
		Response response = Response.success();
		return new Result(response, false);
	}

	public static Result success() {
		Response response = Response.success();
		return new Result(response, false);
	}

	public static Result success(Object value) {
		Response response = Response.success();
		response.put("result", value);
		return new Result(response, false);
	}

	public static Result quit() {
		Response response = Response.success();
		return new Result(response, true);
	}

	public static Result badRequest(String message) {
		Response response = Response.badRequest(message);
		return new Result(response, false);
	}

	public static Result badRequestException(Throwable t) {
		String message = t.getMessage();
		Response response = Response.badRequest(t.getMessage());
		return new Result(response, false);
	}

	public static Result internalError(String message) {
		Response response = Response.internalError(message);
		response.put("message", message);
		return new Result(response, false);
	}

	public static Result internalErrorException(Throwable t) {
		String message = t.getMessage();
		Response response = Response.internalError(message);
		return new Result(response, false);
	}

	static public Result BadRequest(String message) {
		Response response = new Response();
		response.put("code", HttpURLConnection.HTTP_BAD_REQUEST);
		return new Result(response, true);
	}

	public static Result unauthorised() {
		Response response = Response.unauthorized();
		return new Result(response, false);
	}

	public Result(Response response, boolean quit) {
		this.response = response;
		this.quit = quit;
	}

	public Response getResponse() {
		return response;
	}

	public boolean isQuit() {
		return quit;
	}
}
