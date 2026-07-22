package com.rsmaxwell.mqtt.rpc.common;

import java.util.Map;

public record Request(
        String function,
        Map<String, Object> args) {

    public Request {
        args = Map.copyOf(args);
    }

    public Request(String function) {
        this(function, Map.of());
    }
}
