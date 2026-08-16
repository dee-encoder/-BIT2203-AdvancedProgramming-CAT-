import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {

    // Handles adding an item to the cart
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String itemName = request.getParameter("item");

        HttpSession session = request.getSession(true);

        session.setMaxInactiveInterval(30 * 60); // 30 minutes

        // Retrieve the current cart list from the session
        List<String> cart = (List<String>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        if (itemName != null && !itemName.trim().isEmpty()) {
            cart.add(itemName);
        }

        // Save the updated cart back into the session
        session.setAttribute("cart", cart);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>Item added: " + itemName + "</p>");
        out.println("<p>Total items in cart: " + cart.size() + "</p>");
    }

    // Handles displaying/retrieving the cart contents (e.g., on the checkout page)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        List<String> cart = (List<String>) session.getAttribute("cart");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Your Shopping Cart</h2>");

        if (cart == null || cart.isEmpty()) {
            out.println("<p>Your cart is empty.</p>");
        } else {
            out.println("<ul>");
            for (String item : cart) {
                out.println("<li>" + item + "</li>");
            }
            out.println("</ul>");
            out.println("<p>Total items: " + cart.size() + "</p>");
        }
    }
}
