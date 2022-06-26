What we want:

mkdir linking && \
cp application.jar linking && cd linking && \
jar -xvf application.jar && \
DEPS=`jdeps --print-module-deps --multi-release 17 --ignore-missing-deps --class-path='./BOOT-INT/lib/*' --module-path='./BOOT-INT/lib/*' application.jar` && \
echo $DEPS && \
jlink --no-header-files --no-man-pages --compress 2 --add-modules $DEPS --output /opt/java-runtime