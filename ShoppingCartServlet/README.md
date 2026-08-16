# ShoppingCartServlet.java

## Description
A Java Servlet demonstrating correct shopping cart session management using `HttpSession`, addressing a common e-commerce bug where the cart appears empty at checkout.

## The Problem
Shopping cart data disappearing at checkout is most often caused by:
- Storing cart items in **request scope** instead of **session scope** — data is lost as soon as one request/response cycle ends
- Inconsistent session retrieval (e.g., mixing `getSession(true)` and `getSession(false)`), accidentally creating a new session on a later request
- Session timeout due to inactivity
- Incorrectly storing cart data as a servlet instance variable (shared/unsafe across users, since servlets are typically singleton instances)

## Techniques Demonstrated
1. **Session-scoped storage** — the cart (`List<String>`) is stored via `session.setAttribute("cart", cart)`, so it persists across multiple page requests for the same user.
2. **Consistent session handling** — every method uses `request.getSession(true)`, ensuring the same session is retrieved (not recreated) on each request, plus a defined timeout via `setMaxInactiveInterval(30 * 60)`.

## Methods
- `doPost(...)` — adds an item to the cart, stored in the session
- `doGet(...)` — retrieves and displays all items currently in the cart

## How to Run
Requires a servlet container (Apache Tomcat), since Servlets don't run as standalone Java programs.

1. Compile with the Servlet API on the classpath: javac -cp servlet-api.jar ShoppingCartServlet.java
2. Deploy to a Tomcat webapp and access via: http://localhost:8080/jgrasp/ShoppingCartServlet

## Requirements
- Apache Tomcat to run
