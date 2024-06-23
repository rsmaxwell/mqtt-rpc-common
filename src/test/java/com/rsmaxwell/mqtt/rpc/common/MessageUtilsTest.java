package com.rsmaxwell.mqtt.rpc.common;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MessageUtilsTest {
	@Test
	void testGetMessage() {

		Map<String, Object> map = new HashMap<>();
		String key = "one";
		String value = "aaaaa";
		map.put(key, value);

		assertDoesNotThrow(() -> {
			String result = Utilities.getString(map, key);
			assertEquals(result, value);
		});
	}
}
