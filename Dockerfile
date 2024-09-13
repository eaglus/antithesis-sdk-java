FROM alpine:3.20.3
RUN apk add --no-cache build-base gradle make openjdk21 patchelf swig

COPY gradle gradle
COPY ffi ffi
COPY sdk sdk
COPY gradlew* default.nix gradle.properties LICENSE lombok* README* settings.gradle shell.nix ./

RUN gradle build
