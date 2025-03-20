package brainacadorg.servlets;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "quoteServlet", value = "/quote-servlet")
public class QuoteServlet extends HttpServlet {

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Any fool can write code that a computer can understand. Good programmers write code that humans can understand</h2>");
        out.println("<p>- Martin Fowler</p>");
        out.println("</body></html>");
    }

    public void destroy() {}
}
