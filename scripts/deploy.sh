#!/bin/sh

set -x 

BASEDIR=$(dirname "$0")
SCRIPT_DIR=$(cd $BASEDIR && pwd)
SUBPROJECT_DIR=$(dirname $SCRIPT_DIR)
PROJECT_DIR=$(dirname $SUBPROJECT_DIR)

. ${PROJECT_DIR}/buildinfo


cd ${SUBPROJECT_DIR}

${PROJECT_DIR}/gradlew :mqtt-rpc-common:publish --no-daemon --info --warning-mode all \
    -PrepositoryName=${REPOSITORY} \
    -PprojectVersion=${VERSION}
