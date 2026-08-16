import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/LifecycleDemoServlet")
public class LifecycleServlet extends HttpServlet {

    // STAGE 1: Constructor — called once when the container instantiates the servlet
    public LifecycleServlet() {
        super();
        System.out.println("[LIFECYCLE] Constructor called - Servlet instance created.");
    }

    // STAGE 2: init() — called once, before the servlet handles any requests
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("[LIFECYCLE] init() called - Servlet is being initialized. " +
                "One-time setup (e.g., opening resources) happens here.");
    }

    // STAGE 3: service() — called for every incoming request
    // Overriding it here to log before delegating to HttpServlet's default dispatch logic
    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        System.out.println("[LIFECYCLE] service() called - Handling an incoming request.");
        super.service(request, response); // delegates to doGet/doPost/etc.
    }

    // Handles GET requests specifically (dispatched from service())
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("[LIFECYCLE] doGet() called - Processing a GET request.");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>LifecycleDemoServlet</h2>");
        out.println("<p>This request was handled by doGet(). Check the server console for lifecycle logs.</p>");
    }

    // Handles POST requests specifically (dispatched from service())
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("[LIFECYCLE] doPost() called - Processing a POST request.");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>POST request handled.</p>");
    }

    // STAGE 4: destroy() — called once, when the container removes the servlet from service
    @Override
    public void destroy() {
        System.out.println("[LIFECYCLE] destroy() called - Servlet is being taken out of service. " +
                "Cleanup (e.g., closing resources) happens here.");
        super.destroy();
    }
}