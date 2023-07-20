# microprofile

Minimal Helidon MP project suitable to start from scratch.

## Build and run


With JDK17+
```bash
mvn package
java -jar target/chapter-09-microprofile.jar 
```

## Exercise the application
```
curl -X GET http://localhost:8080/simple-greet
{"message":"Hello World!"}
```

```
curl -X GET http://localhost:8080/greet
{"message":"Hello World!"}

curl -X GET http://localhost:8080/greet/Joe
{"message":"Hello Joe!"}

curl -X PUT -H "Content-Type: application/json" -d '{"greeting" : "Hola"}' http://localhost:8080/greet/greeting

curl -X GET http://localhost:8080/greet/Jose
{"message":"Hola Jose!"}
```