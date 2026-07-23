# Week 4: Microservices with Spring Cloud

For the Microservices week, the exercises focus on how different applications register, discover, and talk to each other using Spring Cloud. 

Instead of building one massive app, I broke the requirements down into the three essential Spring Cloud components needed to demonstrate a working microservices ecosystem:

1.  **`eureka-server`**: The Service Registry running on port 8761. All other services will register here.
2.  **`api-gateway`**: The routing gateway running on port 8080.
3.  **`employee-service`**: A simple backend REST service running on port 8081 that registers itself as a client with Eureka.

### How to test:
Run `eureka-server` first, followed by the `api-gateway` and `employee-service`. You can then access the Eureka dashboard at `http://localhost:8761` to see the registered instances.
