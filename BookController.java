import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/BookController")
public class BookController extends HttpServlet {

    private BookDAO bookDAO;

    @Override
    public void init() throws ServletException {
        // Initialize the DAO once when the servlet is created
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Controller calls the Model (BookDAO) to retrieve data
        List<Book> bookList = bookDAO.getAllBooks();

        // Store the data as a request attribute so the View can access it
        request.setAttribute("bookList", bookList);

        // Forward the request to the View (JSP) for rendering
        RequestDispatcher dispatcher = request.getRequestDispatcher("bookList.jsp");
        dispatcher.forward(request, response);
    }
}