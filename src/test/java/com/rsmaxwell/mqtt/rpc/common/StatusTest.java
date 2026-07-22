package com.rsmaxwell.mqtt.rpc.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.HttpURLConnection;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

class StatusTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void createsStatus() {
        Status status = new Status(
                HttpURLConnection.HTTP_BAD_REQUEST,
                "invalid request");

        assertEquals(HttpURLConnection.HTTP_BAD_REQUEST, status.code());
        assertEquals("invalid request", status.message());
    }

    @Test
    void retainsCompatibilityGetters() {
        Status status = new Status(
                HttpURLConnection.HTTP_BAD_REQUEST,
                "invalid request");

        assertEquals(status.code(), status.getCode());
        assertEquals(status.message(), status.getMessage());
    }

    @Test
    void identifiesSuccessfulStatus() {
        assertTrue(Status.OK.isOk());
        assertFalse(Status.BAD_REQUEST.isOk());
    }

    @Test
    void hasValueEquality() {
        Status first = new Status(400, "bad request");
        Status second = new Status(400, "bad request");

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void serializesToExistingJsonShape() throws Exception {
        Status status = new Status(400, "bad request");

        String json = mapper.writeValueAsString(status);

        assertEquals(
                "{\"code\":400,\"message\":\"bad request\"}",
                json);
    }

    @Test
    void deserializesFromExistingJsonShape() throws Exception {
        String json = """
                {
                  "code": 400,
                  "message": "bad request"
                }
                """;

        Status status = mapper.readValue(json, Status.class);

        assertEquals(400, status.code());
        assertEquals("bad request", status.message());
    }

    @Test
    void preservesCustomStringRepresentation() {
        Status status = new Status(400, "bad request");

        assertEquals(
                "code:400, message: 'bad request'",
                status.toString());
    }
}