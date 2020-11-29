# spring-boot-jsonrpc4j sample project

Simple demo project for a **jsonrpc4j** framework.


## How to test:

```bash
cd project_dir
mvn clean install -DskipTests
java -jar target/JsonRPC-0.0.1-SNAPSHOT.jar

curl -v -H "Content-Type: application/json" -d '{"id":0, "method":"sayHello", "params":["pop"]}' http://localhost:8080/rpc/myservice 
curl -v -H "Content-Type: application/json" -d '{"id":0, "method":"saveCar", "params":[{"id":2,"name":"test","enabled":true}]}' http://localhost:8080/rpc/myservice 

mvn -Dtest=MyServiceImplTest#sayHello test
mvn -Dtest=MyServiceImplTest#saveCar test
```

## Sample output

```
"method":"saveCar", "params":[{"id":2,"name":"test","enabled":true}]}' http://localhost:8080/rpc/myservice 
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> POST /rpc/myservice HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.68.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 78
> 
* upload completely sent off: 78 out of 78 bytes
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
< Content-Type: application/json-rpc
< Content-Length: 36
< Date: Sun, 29 Nov 2020 15:49:51 GMT
< 
{"jsonrpc":"2.0","id":0,"result":2}
* Connection #0 to host localhost left intact
```

## Links

* [Source code of MyServiceImplTest.java](https://github.com/pponec/spring-boot-jsonrpc4j/blob/master/src/test/java/sub/optimal/jsonrpc/impl/MyServiceImplTest.java)
* [Is Java Remote Procedure Call Dead in the REST Age?](https://dzone.com/articles/is-java-remote-procedure-call-dead-in-the-rest-age)
* [An original project](https://github.com/SubOptimal/spring-boot-jsonrpc4j)
