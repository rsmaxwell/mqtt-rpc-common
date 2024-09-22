package com.rsmaxwell.mqtt.rpc.common;

import lombok.ToString;

@ToString
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

	public static Result internalError(String message) {
		Response response = Response.internalError(message);
		response.put("message", message);
		return new Result(response, false);
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
