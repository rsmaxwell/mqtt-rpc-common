package com.rsmaxwell.mqtt.rpc.common;

import java.util.Map;

public abstract class Utilities {

	public static Object put(Map<String, Object> map, String key, Object value) {
		return map.put(key, value);
	}

	public static boolean containsKey(Map<String, Object> map, String key) {
		return map.containsKey(key);
	}

	public static String getString(Map<String, Object> map, String key) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			throw new Exception(String.format("could not find the key [%s]", key));
		}

		Object obj = map.get(key);
		if ((obj instanceof String) == false) {
			throw new Exception(String.format("unexpected type for key: %s, %s", key, obj.getClass().getSimpleName()));
		}

		return obj.toString();
	}

	public static Integer getInteger(Map<String, Object> map, String key) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			throw new Exception(String.format("could not find the key [%s]", key));
		}

		Object obj = map.get(key);
		if ((obj instanceof Integer) == false) {
			throw new Exception(String.format("unexpected type for key: %s, %s", key, obj.getClass().getSimpleName()));
		}

		return (Integer) obj;
	}

	public static Long getLong(Map<String, Object> map, String key) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			throw new Exception(String.format("could not find the key [%s]", key));
		}

		Object obj = map.get(key);

		if ((obj instanceof Number) == false) {
			throw new Exception(String.format("unexpected type for key: %s, %s", key, obj.getClass().getSimpleName()));
		}

		Number temp = (Number) obj;
		return temp.longValue();
	}

	public static Boolean getBoolean(Map<String, Object> map, String key) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			throw new Exception(String.format("could not find the key [%s]", key));
		}

		Object obj = map.get(key);
		if ((obj instanceof Boolean) == false) {
			throw new Exception(String.format("unexpected type for key: %s, %s", key, obj.getClass().getSimpleName()));
		}

		return (Boolean) obj;
	}
}
