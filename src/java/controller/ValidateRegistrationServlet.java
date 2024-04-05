package controller;

import dataaccesslayer.DataSource;
import dataaccesslayer.UserDAOImpl;
import model.UserRegistration;
import transferobjects.UserDTO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet(name = "ValidateRegistrationServlet", urlPatterns = {"/ValidateRegistrationServlet"})
public class ValidateRegistrationServlet extends HttpServlet{
    String name = null;
    String email;
    String password;
    String phone;
    String location;
    String userType;
    String role;
    //TODO we need to figure out what were doing for all the registration forms and how we are going to validate them

    DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        dataSource = new DataSource(context);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); // false means don't create a session if it doesn't exist
        role = (String) session.getAttribute("userType"); // this will get used to store the role into db
        name = request.getParameter("name");
        email = request.getParameter("email");
        password = request.getParameter("password");
        phone = request.getParameter("phone");
        location = request.getParameter("location");
       // role = request.getParameter("role");
        try (Connection connection = dataSource.getConnection()) {

            if (name == null || email == null || password == null || phone == null || location == null || role == null) {
                // TODO different type of validation not the null type, need regex method in model class
                out.println("Please fill all the fields.");
            } else {
                // Create a new UserDTO object
                UserDTO user = new UserDTO();
                user.setName(name);
                user.setPassword(password);
                user.setRole(role);
                user.setMail(email);
                user.setPhone(phone);
                user.setLocation(location);
                UserDAOImpl userDAO = new UserDAOImpl(connection);
                userDAO.insertUser(user);
                out.println("User registered successfully!");
            }
        }catch (SQLException e) {
                out.println("Failed to register user. Please try again later.");
                e.printStackTrace();
            }

        // TODO maybe a validation method that makes sure we have unique phone numbers and emails?
        // we do not need to validate that the fields are not empty because the form will not submit if they are
        response.sendRedirect("views/Signin.jsp");
    }
}
