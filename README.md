# Hello-World 
Plain dockerized Kotlin hello-world application with Spring Boot.

## How to build the application

To build this application execute the following command:

    ./gradlew clean build

## Useful Docker commands

    docker build \
        --tag dev.niksta/hello-world:1.0.0 \
        --build-arg APP_NAME=hello-world \
        --build-arg JAR_FILE=hello-world.jar \
        --file Dockerfile \
        .

    docker run \
        -p 8080:8080 \
        --name hello-world \
        --detach \
        dev.niksta/hello-world:1.0.0

    docker exec -it hello-world /bin/sh

    docker stop hello-world
    docker rm hello-world

# License

    This is free and unencumbered software released into the public domain.
    
    Anyone is free to copy, modify, publish, use, compile, sell, or
    distribute this software, either in source code form or as a compiled
    binary, for any purpose, commercial or non-commercial, and by any
    means.
    
    In jurisdictions that recognize copyright laws, the author or authors
    of this software dedicate any and all copyright interest in the
    software to the public domain. We make this dedication for the benefit
    of the public at large and to the detriment of our heirs and
    successors. We intend this dedication to be an overt act of
    relinquishment in perpetuity of all present and future rights to this
    software under copyright law.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
    EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
    MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
    IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
    OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
    ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
    OTHER DEALINGS IN THE SOFTWARE.
    
    For more information, please refer to <https://unlicense.org>