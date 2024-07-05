#!/bin/sh

BASEDIR=$(dirname "$0")
SCRIPT_DIR=$(cd $BASEDIR && pwd)
SUBPROJECT_DIR=$(dirname $SCRIPT_DIR)
PROJECT_DIR=$(dirname $SUBPROJECT_DIR)
BUILD_DIR=${SUBPROJECT_DIR}/build

. ${BUILD_DIR}/buildinfo




tree ${SUBPROJECT_DIR}




cd ${PROJECT_DIR}


${PROJECT_DIR}/gradlew :mqtt-rpc-common:publish \
    -PrepositoryName=${REPOSITORY} \
    -PprojectVersion=${VERSION}

    
ls -al ${SUBPROJECT_DIR}/build/libs

jar -tf ${SUBPROJECT_DIR}/build/libs/*.jar


