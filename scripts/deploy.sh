#!/bin/sh


BASEDIR=$(dirname "$0")
SCRIPT_DIR=$(cd $BASEDIR && pwd)
SUBPROJECT_DIR=$(dirname $SCRIPT_DIR)
PROJECT_DIR=$(dirname $SUBPROJECT_DIR)
BUILD_DIR=${SUBPROJECT_DIR}/app/build

. ${BUILD_DIR}/buildinfo


cd ${SUBPROJECT_DIR}

${PROJECT_DIR}/gradlew publish --no-daemon --info \
    -PrepositoryName=${REPOSITORY} \
    -PprojectVersion=${VERSION}
