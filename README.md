# mqtt-rpc-common

# Overview

The top level gradle project takes advantage of the support mqtt v5 offers for request/response messageing. It allows a set of requestor clients to send a message to a responder client which will process the request and send a response back to the original requester. This messaging pattern can coesist with the normal publish/subscribe pattern.  

The application is expected to load the requester client with a number of allowed requests and also load a responder with an equivalent number of handler classes which generate an appropriate response. 

Also a Mosquitto broker is expected to be running, to which the clients connect.

However this subproject implements the common classes used by both the requester and the responders api's



## Build

 - Install Java JDK at least version 17

 - Create a file names %USERPROFILE%\.gradle\gradle.properties containing the credentials for the the repository containing the build output:
 
    mavenUser = {username}
    mavenPassword = {password}
     

 - Run %PROJECT_DIR%\scripts\build, (which will build the library to:  %PROJECT_DIR%\\mqtt-rpc-common\build\libs )
 - Run %PROJECT_DIR%\scripts\test, (which will run the projects tests)
 - Run %PROJECT_DIR%\scripts\deploy, (which will deploy the library to the repository )

