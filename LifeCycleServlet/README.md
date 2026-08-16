# LifecycleServlet.java

## Description
A Java Servlet that demonstrates the full servlet lifecycle managed by the web container — from instantiation through to destruction — with console log messages marking each stage.

## Lifecycle Stages
| Stage | Method | Called | What Happens |
| Loading/Instantiation | Constructor | Once | Container creates the servlet object |
| Initialization | `init()` | Once | One-time setup (e.g., opening resources) |
| Request Handling | `service()` → `doGet()`/`doPost()` | Once per request | Processes each client request |
| Destruction | `destroy()` | Once | Cleanup before the servlet is removed from service |

## How to Run
Requires a servlet container (Apache Tomcat), since Servlets don't run as standalone Java programs.

1. Compile with the Servlet API on the classpath: javac -cp servlet-api.jar LifecycleDemoServlet.java
2. Deploy to a Tomcat webapp and access via: http://localhost:8080/yourapp/LifecycleDemoServlet
3. Watch the Tomcat console output — it will print lifecycle log messages in order as the servlet is initialized, handles requests, and is eventually destroyed.

## Requirements
- Java Servlet API
- Apache Tomcat to run
