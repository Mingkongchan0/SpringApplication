# SpringApplication
1.GET from http://localhost:8080/sayHello
//Value retrieved should be "H 3 L L 0 prod"

2.POST to http://localhost:8080/actuator/env
{"name": "spring.profiles.active", "value": "test"}

3.GET from http://localhost:8080/sayHello
//Value retrieved should be "H 3 L L 0 test"
  
