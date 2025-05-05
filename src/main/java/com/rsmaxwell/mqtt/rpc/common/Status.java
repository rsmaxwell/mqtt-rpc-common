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
}
