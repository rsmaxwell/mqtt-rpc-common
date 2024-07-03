package com.rsmaxwell.mqtt.rpc.common.buildinfo;

import lombok.Getter;

public abstract class AbstractBuildInfo implements IBuildInfo {

	@Getter
	protected String name;

	@Getter
	protected String version;

	@Getter
	protected String buildID;

	@Getter
	protected String builddate;

	@Getter
	protected String gitCommit;

	@Getter
	protected String gitBranch;

	@Getter
	protected String gitURL;

	public void printAll() throws Exception {
		System.out.printf("%s\n", name);
		System.out.printf("    version:   %s\n", version);
		System.out.printf("    buildID:   %s\n", buildID);
		System.out.printf("    builddate: %s\n", builddate);
		System.out.printf("    gitCommit: %s\n", gitCommit);
		System.out.printf("    gitBranch: %s\n", gitBranch);
		System.out.printf("    gitURL:    %s\n", gitURL);
	}
}
