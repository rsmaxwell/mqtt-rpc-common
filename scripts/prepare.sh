#!/bin/sh






if [ -z "${BUILD_ID}" ]; then
    BUILD_ID="(none)"
    VERSION="0.0.1-SNAPSHOT"
    REPOSITORY=snapshots
    REPOSITORYID=snapshots
else
    VERSION="0.0.1.$((${BUILD_ID}))"
    REPOSITORY=releases
    REPOSITORYID=releases
fi




BASEDIR=$(dirname "$0")
SCRIPT_DIR=$(cd $BASEDIR && pwd)
PROJECT_DIR=$(dirname $SCRIPT_DIR)
SOURCE_DIR=${PROJECT_DIR}/src
BUILD_DIR=${PROJECT_DIR}/app/build
TEMPLATES_DIR=${PROJECT_DIR}/templates






PROJECT=mqtt-rpc-common
GROUPID=com.rsmaxwell.mqtt.rpc
ARTIFACTID=${PROJECT}
PACKAGING=zip
ZIPFILE=${ARTIFACTID}_${VERSION}.${PACKAGING}



TIMESTAMP="$(date '+%Y-%m-%d %H:%M:%S')"
GIT_COMMIT="${GIT_COMMIT:-(none)}"
GIT_BRANCH="${GIT_BRANCH:-(none)}"
GIT_URL="${GIT_URL:-(none)}"

export PROJECT
export REPOSITORY
export REPOSITORYID
export BUILD_ID
export VERSION
export TIMESTAMP
export GIT_COMMIT
export GIT_BRANCH
export GIT_URL



cd ${TEMPLATES_DIR}

tags='$PROJECT,$REPOSITORY,$REPOSITORYID,$VERSION,$BUILD_ID,$TIMESTAMP,$GIT_COMMIT,$GIT_BRANCH,$GIT_URL'

find . -type f | while read filename; do
    echo "Writing ${filename}"
    file=${SOURCE_DIR}/${filename}
    dir=${directory ${file}}
    mkdir -p ${dir}
    envsubst "${tags}" < ${filename} > ${file}
done




mkdir -p ${BUILD_DIR}
cd ${BUILD_DIR}

cat > buildinfo <<EOL
BUILD_ID="${BUILD_ID}"
VERSION="${VERSION}"
REPOSITORY="${REPOSITORY}"
REPOSITORYID="${REPOSITORYID}"
REPOSITORY_URL="${REPOSITORY_URL}"
PROJECT="${PROJECT}"
GROUPID="${GROUPID}"
ARTIFACTID="${ARTIFACTID}"
PACKAGING="${PACKAGING}"
ZIPFILE="${ZIPFILE}"
TIMESTAMP="${TIMESTAMP}"
GIT_COMMIT="${GIT_COMMIT}"
GIT_BRANCH="${GIT_BRANCH}"
GIT_URL="${GIT_URL}"
EOL

pwd
ls -al 
cat buildinfo