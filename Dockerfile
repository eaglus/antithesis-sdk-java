FROM alpine:3.20.3
RUN apk add --no-cache build-base gradle make openjdk21 patchelf swig

WORKDIR /antithesis-sdk
COPY gradle gradle
COPY ffi ffi
COPY sdk sdk
COPY gradlew* default.nix gradle.properties LICENSE lombok* README* settings.gradle shell.nix ./
COPY libvoidstar.so ./dist/

RUN gradle build
RUN cp sdk/build/libs/*.jar ffi/build/libs/*.jar ffi/src/main/resources/*.*  dist
WORKDIR /antithesis-sdk/dist
