package brainacadorg.servlets;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "historyServlet", value = "/history-servlet")
public class HistoryServlet extends HttpServlet {
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Історія розвитку виробника</h2>");
        out.println("<p>Dell була заснована в 1984 році Майклом Деллом. За час свого існування компанія пройшла через кілька етапів розвитку...</p>");
        out.println("<p><strong>Рік заснування:</strong> 1984</p>");
        out.println("<p><strong>Ключові події:</strong> Запуск персональних комп'ютерів, вихід на міжнародний ринок, впровадження інновацій в серверній та мережевій інфраструктурі...</p>");
        out.println("<p><img src='/images/dell_history1.jpg' alt='History Image 1' /></p>");
        out.println("<p><a href='https://www.dell.com/'>Більше про історію на офіційному сайті</a></p>");
        out.println("<a href='general-info-servlet'>Назад</a>");
        out.println("</body></html>");
    }

    public void destroy() {}
}
