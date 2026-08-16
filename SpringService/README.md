# Spring Dependency Injection

## Description
Demonstrates Dependency Injection (DI) in the Spring Framework using constructor injection, where a `UserService` depends on a `UserRepository`.

## Files
- `UserRepository.java` — Spring `@Repository` bean simulating a data access layer
- `UserService.java` — Spring `@Service` bean that receives `UserRepository` via its constructor
- `AppConfig.java` — Spring `@Configuration` class that uses `@ComponentScan` to detect and register the beans

## What is Dependency Injection?
DI is a design pattern where an object's dependencies are provided externally (by the Spring container) rather than the object creating them itself. This produces loosely-coupled, more testable, and more maintainable code.

## Constructor Injection vs Setter Injection
- **Constructor Injection** (used here): dependencies are passed as constructor arguments and typically declared `final`. Guarantees the object is fully initialized and valid immediately upon creation — ideal for required dependencies.
- **Setter Injection**: dependencies are provided via setter methods after object creation, allowing them to be optional or changed later — more flexible, but less strict about ensuring dependencies are always present.

## How to Run
Requires Spring Framework jars (`spring-core`, `spring-context`, `spring-beans`) on the classpath: javac -cp spring-libs/* UserRepository.java UserService.java AppConfig.java

## Requirements
- Spring Framework core dependencies
- Java 8+
