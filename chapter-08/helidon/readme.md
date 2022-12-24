# MicroProfile generated Application

## Introduction

MicroProfile Starter has generated this MicroProfile application for you.

The generation of the executable jar file can be performed by issuing the following command

```shell
mvn clean package
``

This will create an executable jar file **restaurant.jar** within the _target_ maven folder. This can be started by executing the following command

```shell
java -jar target/garage.jar
```

To launch the test page, open your browser at the following URL

```shell
http://localhost:8080/index.html  
```


To execute the tests:

```shell

curl --location --request POST 'http://localhost:8080/garage' \
--header 'Content-Type: application/json' \
--data-raw '{"make": "Dodge", "model": "Wagon", "year": 1993, "plate": "JN8AE2KP7D9956349"}'

curl --location --request POST 'http://localhost:8080/garage' \
--header 'Content-Type: application/json' \
--data-raw '{"make": "Ford", "model": "F250", "year": 2005, "plate": "WBANE73577B200053"}'

curl --location --request POST 'http://localhost:8080/garage' \
--header 'Content-Type: application/json' \
--data-raw '{"make": "Honda", "model": "S2000", "year": 2005, "plate": "WBANE73577B200053"}'

curl --location --request POST 'http://localhost:8080/garage' \
--header 'Content-Type: application/json' \
--data-raw '{"make": "Toyota", "model": "Corolla", "year": 2005, "plate": "WBANE73577B200053"}'




curl --location --request GET 'http://localhost:8080/garage/Corolla'

curl --location --request GET 'http://localhost:8080/garage'
```

Validations tests:

```shell
curl --location --request POST 'http://localhost:8080/restaurants' \
--header 'Content-Type: application/json' \
--data-raw '{"description": "Water appears as a clear, nontoxic liquid composed of hydrogen and oxygen, essential for life.", "type": "BEVERAGE", "expires": "2030-12-03"}'

curl --location --request POST 'http://localhost:8080/restaurants' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "water", "description": "Water appears as a clear, nontoxic liquid composed of hydrogen and oxygen, essential for life.", "type": "BEVERAGE", "expires": "2000-12-03"}'

curl --location --request POST 'http://localhost:8080/restaurants' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "w", "description": "Water appears as a clear, nontoxic liquid composed of hydrogen and oxygen, essential for life.", "type": "BEVERAGE", "expires": "2025-12-03"}'
```


## Specification examples

By default, there is always the creation of a JAX-RS application class to define the path on which the JAX-RS endpoints are available.

Also, a simple Hello world endpoint is created, have a look at the class **HelloController**.

More information on MicroProfile can be found [here](https://microprofile.io/)


