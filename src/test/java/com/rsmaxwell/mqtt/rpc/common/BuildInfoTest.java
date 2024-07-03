package com.rsmaxwell.mqtt.rpc.common;

import com.rsmaxwell.mqtt.rpc.common.buildinfo.BuildInfo;

public class BuildInfoTest {

	public static void main(String[] args) throws Exception {
		BuildInfo info = new com.rsmaxwell.mqtt.rpc.common.buildinfo.BuildInfo();
		info.printAll();
	}

}
