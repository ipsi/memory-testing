java \
    -Xss512K \
    -Xmx96M \
    -Xms96M \
    -XX:MaxMetaspaceSize=64M \
    -XX:MetaspaceSize=64M \
    -XX:InitialCodeCacheSize=64m \
    -XX:ReservedCodeCacheSize=64m \
    -XX:CompressedClassSpaceSize=64m \
    -Dcom.sun.management.jmxremote \
    -XX:NewRatio=11 \
    -XX:SurvivorRatio=10 \
    -XX:+UsePerfData \
    -XX:NativeMemoryTracking=detail \
    -XX:+StartAttachListener \
    -jar \
    target/devourer.jar
