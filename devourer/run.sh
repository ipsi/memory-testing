export MALLOC_ARENA_MAX=2
java \
    -Xss256K \
    -Xmx48M \
    -Xms48M \
    -XX:MaxMetaspaceSize=48M \
    -XX:MetaspaceSize=48M \
    -XX:InitialCodeCacheSize=16m \
    -XX:ReservedCodeCacheSize=16m \
    -XX:CompressedClassSpaceSize=8m \
    -XX:+AlwaysPreTouch \
    -XX:+StartAttachListener \
    -jar \
    target/devourer.jar
