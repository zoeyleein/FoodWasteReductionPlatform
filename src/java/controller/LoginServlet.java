package controller;

import model.LogInValidation;

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
    LogInValidation logInValidation = new LogInValidation();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        //TODO these variables will be passed to model where our logic will happen
        // we need to check as well what type of user they are in the db to redirect them to the correct page
        response.sendRedirect(logInValidation.logInPageRedirect(action, username, password)); // not a finished method


    }

}
