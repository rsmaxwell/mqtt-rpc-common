package com.rsmaxwell.mqtt.rpc.common;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractRequest implements Request {

	String function;
	public Map<String, Object> args = new HashMap<String, Object>();

	public AbstractRequest() {
	}

	public AbstractRequest(String function) {
		this.function = function;
	}

	public Object put(String key, Object value) {
		return args.put(key, value);
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public Map<String, Object> getArgs() {
		return args;
	}

	public void setArgs(Map<String, Object> args) {
		this.args = args;
	}

	abstract public void handle(Response response) throws Exception;
}
