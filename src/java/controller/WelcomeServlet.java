package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "WelcomeServlet", urlPatterns = {"/WelcomeServlet"})
public class WelcomeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("Log In".equals(action)) {
            response.sendRedirect("views/Singin.jsp"); // Assuming the file name is SignIn.jsp
        } else if ("Sign Up".equals(action)) {
            response.sendRedirect("views/register/role_selection.jsp");
        } else {
            // if we have a different action, we can redirect to an error page
        }
    }
}