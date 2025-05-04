package com.rsmaxwell.mqtt.rpc.common.buildinfo;

import lombok.Data;

@Data
public abstract class AbstractBuildInfo implements IBuildInfo {

	protected String name;
	protected String version;
	protected String buildID;
	protected String builddate;
	protected String gitCommit;
	protected String gitBranch;
	protected String gitURL;

	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();
		sb.append(name + "\n");
		sb.append("    version:   " + version + "\n");
		sb.append("    buildID:   " + buildID + "\n");
		sb.append("    builddate: " + builddate + "\n");
		sb.append("    gitCommit: " + gitCommit + "\n");
		sb.append("    gitBranch: " + gitBranch + "\n");
		sb.append("    gitURL:    " + gitURL + "\n");
		return sb.toString();
	}
}
