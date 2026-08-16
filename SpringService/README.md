# Spring Dependency Injection

## Description
Demonstrates Dependency Injection (DI) in the Spring Framework using constructor injection, where a `UserService` depends on a `UserRepository`.

## Files
- `UserRepository.java` — Spring `@Repository` bean simulating a data access layer
- `UserService.java` — Spring `@Service` bean that receives `UserRepository` via its constructor
- `AppConfig.java` — Spring `@Configuration` class that uses `@ComponentScan` to detect and register the beans

## How to Run
Requires Spring Framework jars (`spring-core`, `spring-context`, `spring-beans`) on the classpath: javac -cp spring-libs/* UserRepository.java UserService.java AppConfig.java

## Requirements
- Spring Framework core dependencies
- Java 8+
