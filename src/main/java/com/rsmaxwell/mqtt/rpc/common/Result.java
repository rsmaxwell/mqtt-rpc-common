package com.rsmaxwell.mqtt.rpc.common;

public class Result {

	private Response response;
	private boolean quit;

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
