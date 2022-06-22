# Hello-World 
Plain Kotlin hello-world application with spring boot.

## Docker commands

    docker build \
        --tag io.botscripter/hello-world:1.0.0 \
        --build-arg APP_NAME=hello-world \
        --build-arg JAR_FILE=hello-world.jar \
        .

    docker run \
        -p 8080:8080 \
        io.botscripter/hello-world:1.0.0

        docker run \
            -it \
            --name hello-world \
            -p 8080:8080 \
            io.botscripter/hello-world:1.0.0 \
            /bin/sh

    docker stop hello-world
    docker rm hello-world