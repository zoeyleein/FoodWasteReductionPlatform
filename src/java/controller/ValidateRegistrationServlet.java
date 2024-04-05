package controller;

import dataaccesslayer.DataSource;
import dataaccesslayer.UserDAOImpl;
import model.DTOBuilder;
import model.UserRegistration;

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
    String role;
    //TODO we need to figure out what were doing for all the registration forms and how we are going to validate them
    DTOBuilder builder = new DTOBuilder();
    DataSource dataSource;
    UserRegistration registration = new UserRegistration();

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
        location = request.getParameter("selectedValue");
       // TODO add subscription parameters here
        try (Connection connection = dataSource.getConnection()) {
            if (registration.userExists(name, connection)) {
                response.sendRedirect(registration.registrationErrorRedirect(role));
            } else{// at some point add 10 digit phone number validation if wanted
                UserDAOImpl userDAO = new UserDAOImpl(connection);
                userDAO.insertUser(builder.userBuilder(name, password, role, email, phone, location));
                response.sendRedirect("views/Signin.jsp");
            }
        }catch (SQLException e) {
                out.println("Failed to register user. Please try again later.");
                e.printStackTrace();
            }
    }
}
