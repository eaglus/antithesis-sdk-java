# Antithesis SDK for Java

### Build
This has been successfully built on Linux using
`gradle 8.7`, `groovy 3.0.11` and `openjdk8 8u362-ga`.  

    # Clean and build
    ./gradlew clean
    ./gradlew build

    # Build results
    ls -l build/libs/antithesis-sdk-*.jar

### Runtime
The antithesis SDK for Java will expect the following
at runtime:

    jna 5.13.0
    jackson 2.2.3

