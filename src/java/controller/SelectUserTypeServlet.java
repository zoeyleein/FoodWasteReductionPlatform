package controller;

import model.UserRegistration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author aaronthomp
 */
@WebServlet(name = "SelectUserTypeServlet", urlPatterns = {"/SelectUserTypeServlet"})
public class SelectUserTypeServlet extends HttpServlet {
    UserRegistration registration = new UserRegistration();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userType = request.getParameter("userType");
        request.getSession().setAttribute("userType", userType);
        // find out what the user type is and redirect to the appropriate registration page
        String registrationPage = registration.registrationType(userType);
        if(userType.equals("Error: Unexpected user type")){
            response.sendRedirect("views/registrationError.jsp"); // we need to create this jsp
        }
        else {
            response.sendRedirect(registrationPage);
        }
    }
}