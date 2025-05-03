package com.rsmaxwell.mqtt.rpc.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Status {

	private int code;
	private String message;

}
