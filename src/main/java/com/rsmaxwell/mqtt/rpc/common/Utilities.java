package com.rsmaxwell.mqtt.rpc.common;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
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

	public static String getStringOrNull(Map<String, Object> map, String key) throws Exception {
		return getStringOrDefault(map, key, null);
	}

	public static String getStringOrDefault(Map<String, Object> map, String key, String defaultValue) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			return defaultValue;
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

	public static Integer getIntegerOrNull(Map<String, Object> map, String key) throws Exception {
		return getIntegerOrDefault(map, key, null);
	}

	public static Integer getIntegerOrDefault(Map<String, Object> map, String key, Integer defaultValue) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			return defaultValue;
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

	public static Long getLongOrNull(Map<String, Object> map, String key) throws Exception {
		return getLongOrDefault(map, key, null);
	}

	public static Long getLongOrDefault(Map<String, Object> map, String key, Long defaultValue) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			return defaultValue;
		}

		Object obj = map.get(key);

		if ((obj instanceof Number) == false) {
			throw new Exception(String.format("unexpected type for key: %s, %s", key, obj.getClass().getSimpleName()));
		}

		Number temp = (Number) obj;
		return temp.longValue();
	}

	public static Double getDouble(Map<String, Object> map, String key) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			throw new Exception(String.format("could not find the key [%s]", key));
		}

		Object obj = map.get(key);

		if ((obj instanceof Number) == false) {
			throw new Exception(String.format("unexpected type for key: %s, %s", key, obj.getClass().getSimpleName()));
		}

		Number temp = (Number) obj;
		return temp.doubleValue();
	}

	public static Double getDoubleOrNull(Map<String, Object> map, String key) throws Exception {
		return getDoubleOrDefault(map, key, null);
	}

	public static Double getDoubleOrDefault(Map<String, Object> map, String key, Double defaultValue) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			return null;
		}

		Object obj = map.get(key);

		if ((obj instanceof Number) == false) {
			throw new Exception(String.format("unexpected type for key: %s, %s", key, obj.getClass().getSimpleName()));
		}

		Number temp = (Number) obj;
		return temp.doubleValue();
	}

	public static BigDecimal getBigDecimal(Map<String, Object> map, String key) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			throw new Exception(String.format("could not find the key [%s]", key));
		}

		Object obj = map.get(key);

		if ((obj instanceof Number) == false) {
			throw new Exception(String.format("unexpected type for key: %s, %s", key, obj.getClass().getSimpleName()));
		}

		Number number = (Number) obj;

		BigDecimal decimal;

		if (number instanceof BigDecimal) {
			decimal = (BigDecimal) number;
		} else if (number instanceof Long || number instanceof Integer) {
			decimal = BigDecimal.valueOf(number.longValue());
		} else if (number instanceof Double || number instanceof Float) {
			decimal = BigDecimal.valueOf(number.doubleValue());
		} else {
			decimal = new BigDecimal(number.toString());
		}

		return decimal;
	}

	public static BigDecimal getBigDecimalOrNull(Map<String, Object> map, String key) throws Exception {
		return getBigDecimalOrDefaultValue(map, key, null);
	}

	public static BigDecimal getBigDecimalOrDefaultValue(Map<String, Object> map, String key, BigDecimal defaultValue) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			return defaultValue;
		}

		Object obj = map.get(key);

		if ((obj instanceof Number) == false) {
			throw new Exception(String.format("unexpected type for key: %s, %s", key, obj.getClass().getSimpleName()));
		}

		Number number = (Number) obj;

		BigDecimal decimal;

		if (number instanceof BigDecimal) {
			decimal = (BigDecimal) number;
		} else if (number instanceof Long || number instanceof Integer) {
			decimal = BigDecimal.valueOf(number.longValue());
		} else if (number instanceof Double || number instanceof Float) {
			decimal = BigDecimal.valueOf(number.doubleValue());
		} else {
			decimal = new BigDecimal(number.toString());
		}

		return decimal;
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

	public static Boolean getBooleanOrNull(Map<String, Object> map, String key) throws Exception {
		return getBooleanOrDefault(map, key, null);
	}

	public static Boolean getBooleanOrDefault(Map<String, Object> map, String key, Boolean defaultValue) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			return defaultValue;
		}

		Object obj = map.get(key);
		if ((obj instanceof Boolean) == false) {
			throw new Exception(String.format("unexpected type for key: %s, %s", key, obj.getClass().getSimpleName()));
		}

		return (Boolean) obj;
	}

	public static ByteBuffer getByteBuffer(Map<String, Object> map, String key) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			throw new Exception(String.format("could not find the key [%s]", key));
		}

		Object obj = map.get(key);
		if ((obj instanceof ByteBuffer) == false) {
			throw new Exception(String.format("unexpected type for key: %s, %s", key, obj.getClass().getSimpleName()));
		}

		return (ByteBuffer) obj;
	}

	public static ByteBuffer getByteBufferOrNull(Map<String, Object> map, String key) throws Exception {
		return getByteBufferOrDefault(map, key, null);
	}

	public static ByteBuffer getByteBufferOrDefault(Map<String, Object> map, String key, ByteBuffer defaultValue) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			return defaultValue;
		}

		Object obj = map.get(key);
		if ((obj instanceof ByteBuffer) == false) {
			throw new Exception(String.format("unexpected type for key: %s, %s", key, obj.getClass().getSimpleName()));
		}

		return (ByteBuffer) obj;
	}

	public static byte[] getByteArray(Map<String, Object> map, String key) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			throw new Exception(String.format("could not find the key [%s]", key));
		}

		Object obj = map.get(key);
		if ((obj instanceof byte[]) == false) {
			throw new Exception(String.format("unexpected type for key: %s, %s", key, obj.getClass().getSimpleName()));
		}

		return (byte[]) obj;
	}

	public static byte[] getByteArraySize(Map<String, Object> map, String key, Long size) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			throw new Exception(String.format("could not find the key [%s]", key));
		}

		Object obj = map.get(key);
		if ((obj instanceof byte[]) == false) {
			throw new Exception(String.format("unexpected type for key: %s, %s", key, obj.getClass().getSimpleName()));
		}
		byte[] bytes = (byte[]) obj;

		if (bytes.length != size) {
			throw new Exception(String.format("unexpected size of byte array: key: %s, expected: %d, actual: %d", key, size, bytes.length));
		}

		return bytes;
	}

	public static byte[] getByteArrayMaxSize(Map<String, Object> map, String key, Long maxSize) throws Exception {

		boolean present = map.containsKey(key);
		if (!present) {
			throw new Exception(String.format("could not find the key [%s]", key));
		}

		Object obj = map.get(key);
		if ((obj instanceof byte[]) == false) {
			throw new Exception(String.format("unexpected type for key: %s, %s", key, obj.getClass().getSimpleName()));
		}
		byte[] bytes = (byte[]) obj;

		if (bytes.length > maxSize) {
			throw new Exception(String.format("byte array too long: key: %s, maxSize: %d, actual: %d", key, maxSize, bytes.length));
		}

		return bytes;
	}
}
