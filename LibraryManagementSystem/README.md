# Library Management System — MVC

## Description
A demonstration of the Model-View-Controller (MVC) pattern for a Library Management System, showing the full request flow for viewing all books in the library.

## MVC Component Breakdown
| Component | File | Responsibility |
| Model | `Book.java` | Plain Java object representing a book's data (ID, title, author, ISBN, availability) |
| Model (DAO) | `BookDAO.java` | Retrieves book data; contains all data-access logic, independent of display |
| Controller | `BookController.java` | Servlet that handles the HTTP request, calls the DAO, and forwards data to the View |
| View | `bookList.jsp` | Renders the book list as an HTML table using JSTL; contains no business logic |

## Request Flow
1. User navigates to `/BookController`
2. `BookController` (Controller) receives the GET request
3. Controller calls `BookDAO.getAllBooks()` (Model) to retrieve the book list
4. Controller stores the result as a request attribute (`bookList`)
5. Controller forwards the request to `bookList.jsp` (View)
6. The View iterates over the books using `<c:forEach>` and displays them in a styled HTML table, showing availability status for each book

## How to Run
Requires:
- A servlet container (Apache Tomcat)
- JSTL library (for the `<c:forEach>` / `<c:choose>` tags in the JSP)

1. javac -cp servlet-api.jar Book.java BookDAO.java BookController.java
2. Deploy to Tomcat and access via: http://localhost:8080/jgrasp/BookController

## Why This Follows MVC Properly
- `Book.java` has zero logic beyond data storage — pure Model
- `BookDAO.java` handles only data retrieval — no display formatting or request handling
- `BookController.java` coordinates only — no direct HTML output or data-access code
- `bookList.jsp` handles only presentation — no business logic, just iteration and formatting
