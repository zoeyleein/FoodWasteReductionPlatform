package controller;



import model.UserRegistration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * WelcomeServlet is a controller that handles the welcome page for the application.
 * @author aaronthomp
 */
@WebServlet(name = "WelcomeServlet", urlPatterns = {"/WelcomeServlet"})
public class WelcomeServlet extends HttpServlet {
    UserRegistration userRegistration = new UserRegistration();

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request the servlet request
     * @param response the servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        response.sendRedirect(userRegistration.welcomePageRedirect(action));
        // idk how we want to handle exception/errors
    }
}