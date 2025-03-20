package brainacadorg.servlets;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "newsServlet", value = "/news-servlet")
public class NewsServlet extends HttpServlet {
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Новини</h2>");
        out.println("<h3>Нова модель ноутбука XPS 15</h3>");
        out.println("<p>Випущено нову модель ноутбука XPS 15 з покращеними характеристиками...</p>");
        out.println("<p><img src='/images/xps15.jpg' alt='XPS 15' /></p>");
        out.println("<h3>Партнерство з компанією Intel</h3>");
        out.println("<p>Dell уклала партнерство з Intel для створення нових потужних процесорів...</p>");
        out.println("<p><img src='/images/intel_partnership.jpg' alt='Intel Partnership' /></p>");
        out.println("<a href='general-info-servlet'>Назад</a>");
        out.println("</body></html>");
    }

    public void destroy() {}
}
