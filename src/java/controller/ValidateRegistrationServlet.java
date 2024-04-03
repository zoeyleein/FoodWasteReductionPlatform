package controller;

import model.UserRegistration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ValidateRegistrationServlet", urlPatterns = {"/ValidateRegistrationServlet"})
public class ValidateRegistrationServlet extends HttpServlet{
    String name = null;
    String email;
    String password;
    String phone;
    String location;
    UserRegistration registration = new UserRegistration();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); // false means don't create a session if it doesn't exist
        String userType = null;
        if (session != null) {
            userType = (String) session.getAttribute("userType");
        }
        name = request.getParameter("name");
        email = request.getParameter("email");
        password = request.getParameter("password");
        phone = request.getParameter("phone");
        location = request.getParameter("location");
        boolean isValid = registration.validate(name, email, password, phone, location);


        if (isValid) {
            response.sendRedirect("views/Signin.jsp");
        } else {
            response.sendRedirect(registration.registrationType(userType));
        }

    }
}
