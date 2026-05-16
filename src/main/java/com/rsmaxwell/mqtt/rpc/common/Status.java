package com.rsmaxwell.mqtt.rpc.common;

import java.net.HttpURLConnection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Status {

	private int code;
	private String message;

	@JsonIgnore
	public boolean isOk() throws Exception {
		return (code == HttpURLConnection.HTTP_OK);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("code:" + this.code);
		if (this.message != null) {
			sb.append(", message: '" + this.message + "'");
		}
		return sb.toString();
	}

	public static final Status OK = new Status(HttpURLConnection.HTTP_OK, "ok");
	public static final Status BAD_REQUEST = new Status(HttpURLConnection.HTTP_BAD_REQUEST, "bad request");
	public static final Status UNAUTHORIZED = new Status(HttpURLConnection.HTTP_UNAUTHORIZED, "unauthorized");
	public static final Status FORBIDDEN = new Status(HttpURLConnection.HTTP_FORBIDDEN, "forbidden");
	public static final Status CONFLICT = new Status(HttpURLConnection.HTTP_CONFLICT, "conflict");
	public static final Status INTERNAL_ERROR = new Status(HttpURLConnection.HTTP_INTERNAL_ERROR, "internal error");
	public static final Status NOT_FOUND = new Status(HttpURLConnection.HTTP_NOT_FOUND, "not found");
}
