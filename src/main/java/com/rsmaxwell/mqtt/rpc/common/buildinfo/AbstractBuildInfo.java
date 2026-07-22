package com.rsmaxwell.mqtt.rpc.common.buildinfo;

import java.util.Objects;

public abstract class AbstractBuildInfo implements IBuildInfo {

    protected String name;
    protected String version;
    protected String buildID;
    protected String builddate;
    protected String gitCommit;
    protected String gitBranch;
    protected String gitURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBuildID() {
        return buildID;
    }

    public void setBuildID(String buildID) {
        this.buildID = buildID;
    }

    public String getBuilddate() {
        return builddate;
    }

    public void setBuilddate(String builddate) {
        this.builddate = builddate;
    }

    public String getGitCommit() {
        return gitCommit;
    }

    public void setGitCommit(String gitCommit) {
        this.gitCommit = gitCommit;
    }

    public String getGitBranch() {
        return gitBranch;
    }

    public void setGitBranch(String gitBranch) {
        this.gitBranch = gitBranch;
    }

    public String getGitURL() {
        return gitURL;
    }

    public void setGitURL(String gitURL) {
        this.gitURL = gitURL;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(name)
                .append('\n')
                .append("    version:   ")
                .append(version)
                .append('\n')
                .append("    buildID:   ")
                .append(buildID)
                .append('\n')
                .append("    builddate: ")
                .append(builddate)
                .append('\n')
                .append("    gitCommit: ")
                .append(gitCommit)
                .append('\n')
                .append("    gitBranch: ")
                .append(gitBranch)
                .append('\n')
                .append("    gitURL:    ")
                .append(gitURL)
                .append('\n')
                .toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        AbstractBuildInfo other = (AbstractBuildInfo) object;

        return Objects.equals(name, other.name)
                && Objects.equals(version, other.version)
                && Objects.equals(buildID, other.buildID)
                && Objects.equals(builddate, other.builddate)
                && Objects.equals(gitCommit, other.gitCommit)
                && Objects.equals(gitBranch, other.gitBranch)
                && Objects.equals(gitURL, other.gitURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name,
                version,
                buildID,
                builddate,
                gitCommit,
                gitBranch,
                gitURL);
    }
}