package com.rsmaxwell.mqtt.rpc.common;

public record Response(
        Status status,
        Object payload,
        boolean quit) {

    public static Response status(Status status, Object payload) {
        return new Response(status, payload, false);
    }

    public static Response success() {
        return new Response(Status.OK, null, false);
    }

    public static Response success(Object payload) {
        return new Response(Status.OK, payload, false);    
    }
    
    public static Response quitting() {
        return new Response(Status.OK, null, true);
    }    
    
    public static Response error(Status status, String message) {
        return new Response(
                new Status(status.code(), message),
                null,
                false);
    }
}
