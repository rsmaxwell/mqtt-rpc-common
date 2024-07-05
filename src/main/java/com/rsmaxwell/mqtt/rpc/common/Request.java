package com.rsmaxwell.mqtt.rpc.common;

import java.util.Map;

public interface Request {

	public Object put(String key, Object value);

	public String getFunction();

	public void setFunction(String function);

	public Map<String, Object> getArgs();

	public void setArgs(Map<String, Object> args);

	abstract public void handle(Response response) throws Exception;
}
