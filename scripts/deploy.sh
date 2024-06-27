#!/bin/sh

set -x 

BASEDIR=$(dirname "$0")
SCRIPT_DIR=$(cd $BASEDIR && pwd)
SUBPROJECT_DIR=$(dirname $SCRIPT_DIR)
PROJECT_DIR=$(dirname $SUBPROJECT_DIR)
BUILD_DIR=${SUBPROJECT_DIR}/build

. ${BUILD_DIR}/buildinfo


cd ${PROJECT_DIR}

rm -rf ~/.gradle/gradle.properties

echo "mavenUser = richard"             >  ~/.gradle/gradle.properties
echo "mavenPassword = 59N4257T5h4X2dz" >> ~/.gradle/gradle.properties
echo ""                                >> ~/.gradle/gradle.properties

echo "~/.gradle/gradle.properties"
cat rm -rf ~/.gradle/gradle.properties


${PROJECT_DIR}/gradlew :mqtt-rpc-common:publish --no-daemon --debug --warning-mode all \
    -PrepositoryName=${REPOSITORY} \
    -PprojectVersion=${VERSION}


echo "wait forever ..."
tail -f /dev/null
