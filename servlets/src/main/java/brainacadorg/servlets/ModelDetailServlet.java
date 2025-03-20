package brainacadorg.servlets;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "modelDetailServlet", value = "/model-detail-servlet/*")
public class ModelDetailServlet extends HttpServlet {
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID моделі не вказано");
            return;
        }

        String id = pathInfo.substring(1);

        out.println("<html><body>");
        if ("1".equals(id)) {
            out.println("<h2>Деталі XPS 13</h2>");
            out.println("<p>Повний опис XPS 13, характеристики, фотографії...</p>");
            out.println("<p><img src='/images/xps13_detail.jpg' alt='XPS 13 Detail' /></p>");
        } else if ("2".equals(id)) {
            out.println("<h2>Деталі Alienware</h2>");
            out.println("<p>Повний опис Alienware, характеристики, фотографії...</p>");
            out.println("<p><img src='/images/alienware_detail.jpg' alt='Alienware Detail' /></p>");
        } else {
            out.println("<h2>Ноутбук не знайдено</h2>");
        }
        out.println("<p><a href='/models-servlet'>Повернутися до моделей</a></p>");
        out.println("</body></html>");
    }

    public void destroy() {}
}
