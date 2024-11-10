
Advantages of microservices:
1.No need to deploy entire app for any change
2.we can scale each microservice based on our requirement
3.We can develop each microservice with different tesh stack
4.fault tolerance
5.Faster Development one service can be given to one employee

Disadvantages:
1.Latency and Performance Issues
2.Testing Complexity
3.Difficult Debugging: Debugging issues across multiple services can be challenging, as errors may propagate through several services, making root cause analysis more difficult.
4.Increased Complexity
-------******************Building a Spring Microservices Project*****************-----------------------------
1.Create Admin server add dependencies -> web,admin server,
				<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>de.codecentric</groupId>
			<artifactId>spring-boot-admin-starter-server</artifactId>
		</dependency>

application.yml:

server:
  port: 8231

management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always
	  
Use case:It acts as a centralized management and monitor defferent services in an application.
 It allows users to control settings, check performance, and handle issues easily from one place
---------------------------------------------------------------------------------------------------
2.Create service Registry add dependencies ->Eureka Server
	<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>

application.yml
server:
  port: 8761

spring:
  application:
    name: eureka-server-serviceRegistry

eureka:
  instance:
    hostname: localhost
  client:
    register-with-eureka: false
    fetch-registry: false
Use case: It acts as a service registry, allowing services to find and communicate with each other. 
It helps manage service instances and ensures they can be located and accessed efficiently.
----------------------------------------------------------------------------------------------------
3.Create Actual REST-APIS with below dependencies:
1.Eureka discovery client
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
2.Load Balancer
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-loadbalancer</artifactId>
		</dependency>
3.Ressilliance4j for circuit breaker
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
		</dependency>
4.Admin client
<dependency>
			<groupId>de.codecentric</groupId>
			<artifactId>spring-boot-admin-starter-client</artifactId>
		</dependency>
5.Actuator and AOP
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-aop</artifactId>
		</dependency>
6.Zipkin for tracing requests time
<dependency>
			<groupId>io.micrometer</groupId>
			<artifactId>micrometer-tracing-bridge-brave</artifactId>
		</dependency>
		<dependency>
			<groupId>io.zipkin.reporter2</groupId>
			<artifactId>zipkin-reporter-brave</artifactId>
		</dependency>
7.DataJPA
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
8.web
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
9.Lombok
10.Mysql
11.Validations.

Example:
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.3.2</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.transport</groupId>
	<artifactId>users-ms</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>users-ms</name>
	<description>Project for User Microservice</description>
	<url/>
	<licenses>
		<license/>
	</licenses>
	<developers>
		<developer/>
	</developers>
	<scm>
		<connection/>
		<developerConnection/>
		<tag/>
		<url/>
	</scm>
	<properties>
		<java.version>17</java.version>
		<spring-boot-admin.version>3.3.2</spring-boot-admin.version>
		<spring-cloud.version>2023.0.3</spring-cloud.version>
	</properties>
	<dependencies>
		<!-->
    Below client dependency is used to register our MS in Service Registry
    <-->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
		<!-->
                        Below Dependency used to enable loadbalancer for efficient load balalcing
                        <-->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-loadbalancer</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
		</dependency>
		<dependency>
			<groupId>de.codecentric</groupId>
			<artifactId>spring-boot-admin-starter-client</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-aop</artifactId>
		</dependency>
		<dependency>
			<groupId>io.micrometer</groupId>
			<artifactId>micrometer-tracing-bridge-brave</artifactId>
		</dependency>
		<dependency>
			<groupId>io.zipkin.reporter2</groupId>
			<artifactId>zipkin-reporter-brave</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>

			<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
			<version>3.3.2</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>

		</dependency>
	</dependencies>
	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
			<dependency>
				<groupId>de.codecentric</groupId>
				<artifactId>spring-boot-admin-dependencies</artifactId>
				<version>${spring-boot-admin.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
->Add @EnableDiscoveryClient in starter class to register our application in service registry
->Load balancer is used to when one of the instance fails then it will auto upgrade to another instance
->Circuit Braker used for fault tolerance
->Admin client to register in Admin server 

->To run zipkin C:\ go to this path zipkin-server-3.0.0-rc0-exec.jar
java -jar zipkin-server-3.0.0-rc0-exec.jar

Zipkin server:It is a tool that helps track the journey of requests through defferent services.
It collects and displays data about how long each part of the process takes, 
making it easier to identify and fix performnace issues.

Resilience4j:It is a library that helps applications stay reliable and responsive by providing features like circuit breakers, 
rate limiters, and retries.It allows services to handle failures and maintain overall system stability.


application.yml:

server:
  port: 9999

spring:
  application:
    name: user-ms
  boot:
    admin:
      client:
        url: http://localhost:8231
  datasource:
    url: jdbc:mysql://localhost:3306/freight_transport_region_user
    username: root
    password: 9398434528
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQLDialect

  cloud:
    config:
      import-check:
        enabled: false
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
  instance:
    preferIpAddress: true


SERVICE:
  User_Already_Exists: User already present
  User_Not_Exists: User not available
management:
  health:
    circuitbreakers:
      enabled: true
  endpoints:
    web:
      exposure:
        include: health
  endpoint:
    health:
      show-details: always
resilience4j:
  circuitbreaker:
    instances:
      createWorkItem:
        registerHealthIndicator: true
        ringBufferSizeInClosedState: 10
        ringBufferSizeInHalfOpenState: 5
        waitDurationInOpenState: 10000
        failureRateThreshold: 50
        eventConsumerBufferSize: 10
        automaticTransitionFromOpenToHalfOpenEnabled: true
        slidingWindowSize: 10
        slidingWindowType: COUNT_BASED
        permittedNumberOfCallsInHalfOpenState: 2

      updateWorkItem:
        registerHealthIndicator: true
        ringBufferSizeInClosedState: 10
        ringBufferSizeInHalfOpenState: 5
        waitDurationInOpenState: 10000
        failureRateThreshold: 50
        eventConsumerBufferSize: 10
      getAvailableHarborLocations:
        registerHealthIndicator: true
        ringBufferSizeInClosedState: 10
        ringBufferSizeInHalfOpenState: 5
        waitDurationInOpenState: 10000
        failureRateThreshold: 50
        eventConsumerBufferSize: 10
  retry:
    instances:
      default:
        maxAttempts: 3
        waitDuration: 5000


  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always



---------------------------------------------------------------------------------------------------
Last We have to create API Gateway
API Gateway:It acts as a single entry point for managing requests to multiple microservices. 
It handles tasks like routing requests, enforcing security, and monitoring performance, simplifying how clients interact with the system.

Add below pom.xml file:

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.0.0</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.example</groupId>
	<artifactId>APIGatewayServices</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>APIGatewayServices</name>
	<description>APIGatewayServices</description>
	<properties>
		<java.version>17</java.version>
		<spring-cloud.version>2022.0.0-RC2</spring-cloud.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-webflux</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-gateway</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>io.projectreactor</groupId>
			<artifactId>reactor-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
	<repositories>
		<repository>
			<id>netflix-candidates</id>
			<name>Netflix Candidates</name>
			<url>https://artifactory-oss.prod.netflix.net/artifactory/maven-oss-candidates</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>
		<repository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>
	</repositories>

</project>


application.yml

spring:
  application:
    name: API-Gateway
  cloud:
    gateway:
      routes:
        - id: user-ms
          uri: lb://user-ms
          predicates:
            - Path=/users/**
        - id: terminal-ms
          uri: lb://terminal-ms
          predicates:
            - Path=/terminals/**
        - id: workitem-ms
          uri: lb://workitem-ms
          predicates:
            - Path=/workItems/**
        - id: vehicle-ms
          uri: lb://vehicle-ms
          predicates:
            - Path=/vehicles/**

server:
  port: 9093
eureka:
  instance:
    hostname: localhost		
		

-------------------------------------------------------------------------------------------------------
-------------------------************Building EKART Project**********------------------------
C:\Users\rajas\Ekart create here:

Building EKART Microservices Project
1.User,Payment,Cart,Product
->User can able to create a user account
->able to see products
->able to see user cart items
->able to see user payment details

->Product 

->Product is independent

User may have some entity relation with Payment,order Cart and Products
Use DTO Classes and add some validations into it.
Use ExceptionHandler to catch exceptions
Use RestTemplate to communicate with each MS
as a user i want to get my payment related information and cart, order, product as well implement saga design pattern in order to achieve above requirement

Use Adminserver,zipkin,loadbalancer,Resilience4J,API gateway,service registry.



AdminServer
user-service
product-service

cart-service

payment-service

order-service

EurekaServer

api-gateway

