package com.rsmaxwell.mqtt.rpc.common;

import java.net.HttpURLConnection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public record Status(
        @JsonProperty("code") int code,
        @JsonProperty("message") String message) {

    public static final Status OK =
            new Status(HttpURLConnection.HTTP_OK, "ok");

    public static final Status BAD_REQUEST =
            new Status(HttpURLConnection.HTTP_BAD_REQUEST, "bad request");

    public static final Status UNAUTHORIZED =
            new Status(HttpURLConnection.HTTP_UNAUTHORIZED, "unauthorized");

    public static final Status FORBIDDEN =
            new Status(HttpURLConnection.HTTP_FORBIDDEN, "forbidden");

    public static final Status CONFLICT =
            new Status(HttpURLConnection.HTTP_CONFLICT, "conflict");

    public static final Status INTERNAL_ERROR =
            new Status(HttpURLConnection.HTTP_INTERNAL_ERROR, "internal error");

    public static final Status NOT_FOUND =
            new Status(HttpURLConnection.HTTP_NOT_FOUND, "not found");

    @JsonIgnore
    public boolean isOk() {
        return code == HttpURLConnection.HTTP_OK;
    }

    /*
     * Compatibility methods for existing callers.
     *
     * A record normally exposes code() and message(), but the existing
     * mqtt-rpc API uses getCode() and getMessage().
     */
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("code:");
        builder.append(code);

        if (message != null) {
            builder.append(", message: '");
            builder.append(message);
            builder.append('\'');
        }

        return builder.toString();
    }
}