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
    //TODO we need to figure out what were doing for all the registration forms and how we are going to validate them
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); // false means don't create a session if it doesn't exist
        String userType = (String) session.getAttribute("userType"); // this will get used to store the role into db
        name = request.getParameter("name");
        email = request.getParameter("email");
        password = request.getParameter("password");
        phone = request.getParameter("phone");
        location = request.getParameter("location");

        // TODO maybe a validation method that makes sure we have unique phone numbers and emails?
        // we do not need to validate that the fields are not empty because the form will not submit if they are
        response.sendRedirect("views/Signin.jsp");
    }
}
