#!/bin/bash

VERSION=1.0.0

clear
echo "Build Project ..."

./gradlew clean build docker

function update {
  echo "Push Project ..."
  docker tag io.botscripter/hello-world:${VERSION} registry-curo.umb.cloud/hello-world/hello-world:${VERSION}
  docker push registry-curo.umb.cloud/hello-world/hello-world:${VERSION}
  oc tag --source=docker registry-curo.umb.cloud/hello-world/hello-world:${VERSION} hello-world/hello-world:stable
}

while true; do
    echo "${BOLD}You have to be logged in oc and docker${NOCOLOR}"
    read -p "[y/n] ? " yn
    case $yn in
        [Yy]* ) update; break;;
        [Nn]* ) exit;;
        * ) echo "Please answer y or n.";;
    esac
done