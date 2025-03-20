package brainacadorg.servlets;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "generalInfoServlet", value = "/general-info-servlet")
public class GeneralInfoServlet extends HttpServlet {
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Загальна інформація</h2>");
        out.println("<p><strong>Назва виробника:</strong> Dell Technologies</p>");
        out.println("<p><strong>Країна:</strong> США</p>");
        out.println("<p><strong>Логотип:</strong><br><img src='/images/dell_logo.png' alt='Dell Logo' /></p>");
        out.println("<p><strong>Кількість співробітників:</strong> 165,000</p>");
        out.println("<p><strong>Коротка інформація:</strong> Dell Technologies є світовим лідером у сфері інновацій в комп'ютерних технологіях та інфраструктурі даних.</p>");
        out.println("<a href='history-servlet'>Історія</a>");
        out.println("<a href='news-servlet'>Новини</a>");
        out.println("<a href='models-servlet'>Моделі</a>");
        out.println("</body></html>");
    }

    public void destroy() {}
}
