package controller;

import dataaccesslayer.DataSource;
import model.LogInValidation;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author aaronthomp
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        dataSource = new DataSource(context);
    }
    LogInValidation logInValidation = new LogInValidation();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        //TODO these variables will be passed to model where our logic will happen
        // we need to check as well what type of user they are in the db to redirect them to the correct page
        try (Connection connection = dataSource.getConnection()) {
            //String redirectPath = logInValidation.logInPageRedirect(action, username, password, connection);
            //response.sendRedirect(redirectPath);
            response.sendRedirect(logInValidation.logInPageRedirect(action, username, password, connection)); // not a finished method
        } catch(SQLException e){
            e.printStackTrace();
        }

    }

}
