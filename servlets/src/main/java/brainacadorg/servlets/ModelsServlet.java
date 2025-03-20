package brainacadorg.servlets;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "modelsServlet", value = "/models-servlet")
public class ModelsServlet extends HttpServlet {
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Моделі ноутбуків</h2>");
        out.println("<h3>Model XPS 13</h3>");
        out.println("<p>Опис ноутбука XPS 13. Цей ноутбук має ультратонкий дизайн та потужні характеристики...</p>");
        out.println("<p><img src='/images/xps13.jpg' alt='XPS 13' /></p>");
        out.println("<h3>Model Alienware</h3>");
        out.println("<p>Опис ноутбука Alienware. Це ідеальний ноутбук для геймерів з високою продуктивністю...</p>");
        out.println("<p><img src='/images/alienware.jpg' alt='Alienware' /></p>");
        out.println("<p><a href='/model-detail-servlet/1'>Деталі XPS 13</a></p>");
        out.println("<p><a href='/model-detail-servlet/2'>Деталі Alienware</a></p>");
        out.println("<a href='general-info-servlet'>Назад</a>");
        out.println("</body></html>");
    }

    public void destroy() {}
}
