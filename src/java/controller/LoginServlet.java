package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author aaronthomp
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        // TODO this logic can be moved to a model class at a later time, <- this needs to happen for MVC pattern
        if ("Sign in".equals(action)) {
        //we perform validation, check db to see if user exists and if they do if their info matches

        } else if ("Sign up".equals(action)) {
            response.sendRedirect("views/register/role_selection.jsp");
        } else {
        // error handling possibly idk
        }
    }

}
