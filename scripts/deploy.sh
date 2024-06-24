#!/bin/sh

set -x 

BASEDIR=$(dirname "$0")
SCRIPT_DIR=$(cd $BASEDIR && pwd)
PROJECT_DIR=$(dirname $SCRIPT_DIR)
BUILD_DIR=${PROJECT_DIR}/app/build

. ${BUILD_DIR}/buildinfo


tree -L 4


cd ${PROJECT_DIR}

ls -al 
ls -al ..
ls -al ../..

../../gradlew publish --no-daemon --info \
    -PrepositoryName=${REPOSITORY} \
    -PprojectVersion=${VERSION}
