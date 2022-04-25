# spring-zookeeper-demo

Showcases how zookeeper and spring can be integrated by using spring-cloud-starter-zookeeper-config.

# How to run

Make sure that you run a zookeeper instance and maybe also a zoonavigator to manipulate values:

````
docker run -p 2181:2181 zookeeper
docker run \                                                                                                          ─╯
  -d \
  -p 9005:9000 \
  -e HTTP_PORT=9000 \
  --name zoonavigator_2 \
  --restart unless-stopped \
  elkozmon/zoonavigator:latest
````

Build the app and run it

```
mvn clean install
java -jar target/spring-zookeeper-demo-0.0.1-SNAPSHOT.jar
```

You should see the app react on changes in the zookeeper.
