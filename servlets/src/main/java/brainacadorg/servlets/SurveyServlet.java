package brainacadorg.servlets;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "surveyServlet", value = "/survey-servlet")
public class SurveyServlet extends HttpServlet {

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='uk'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Анкета</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Анкета користувача</h2>");
        out.println("<form action='survey-servlet' method='post'>");
        out.println("<label for='fullName'>ПІБ:</label>");
        out.println("<input type='text' id='fullName' name='fullName' required><br><br>");

        out.println("<label for='phone'>Телефон:</label>");
        out.println("<input type='text' id='phone' name='phone' pattern='\\+?[0-9]{10,15}' title='Введіть правильний номер телефону' required><br><br>");

        out.println("<label for='email'>Email:</label>");
        out.println("<input type='email' id='email' name='email' required><br><br>");

        out.println("<label for='age'>Вік:</label>");
        out.println("<input type='number' id='age' name='age' min='1' required><br><br>");

        out.println("<label for='gender'>Стать:</label>");
        out.println("<select id='gender' name='gender' required>");
        out.println("<option value='male'>Чоловік</option>");
        out.println("<option value='female'>Жінка</option>");
        out.println("<option value='other'>Інше</option>");
        out.println("</select><br><br>");

        out.println("<label for='subscribe'>Хочете підписатися на нашу розсилку?</label>");
        out.println("<input type='checkbox' id='subscribe' name='subscribe'><br><br>");

        out.println("<input type='submit' value='Відправити'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String ageStr = request.getParameter("age");
        String gender = request.getParameter("gender");
        boolean subscribe = request.getParameter("subscribe") != null;

        if (fullName == null ||
                fullName.isEmpty() ||
                phone == null ||
                phone.isEmpty() ||
                email == null ||
                email.isEmpty() ||
                ageStr == null ||
                ageStr.isEmpty() ||
                gender == null ||
                gender.isEmpty()) {
            response.getWriter().println("<h3>Будь ласка, заповніть всі поля!</h3>");
            return;
        }

        int age = 0;
        try {
            age = Integer.parseInt(ageStr);
            if (age <= 0) {
                response.getWriter().println("<h3>Вік має бути додатнім числом!</h3>");
                return;
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("<h3>Введіть правильний вік!</h3>");
            return;
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Результати анкети</h2>");
        out.println("<p><strong>ПІБ:</strong> " + fullName + "</p>");
        out.println("<p><strong>Телефон:</strong> " + phone + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Вік:</strong> " + age + "</p>");
        out.println("<p><strong>Стать:</strong> " + (gender.equals("male") ? "Чоловік" : gender.equals("female") ? "Жінка" : "Інше") + "</p>");
        out.println("<p><strong>Підписка на розсилку:</strong> " + (subscribe ? "Так" : "Ні") + "</p>");
    }

    public void destroy() {}
}
