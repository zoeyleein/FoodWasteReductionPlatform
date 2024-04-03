package controller;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userType = request.getParameter("userType");




        // find out what the user type is and redirect to the appropriate registration page
        switch (userType) {
            case "Customer":
                response.sendRedirect("views/register/Customer_registration.jsp");
                break;
            case "Retailer":
                response.sendRedirect("views/register/Retailer_registration.jsp");
                break;
            case "Charity":
                response.sendRedirect("views/register/Charity_registration.jsp");
                break;
            default:
                // idk if we need a default case here, combo box should limit it to 3 options
                break;
        }
    }
}