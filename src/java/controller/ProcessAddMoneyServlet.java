package controller;

import businesslayer.UserAccountBusinessLogic;
import dataaccesslayer.DataSource;
import transferobjects.UserAccountDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * ProcessAddMoneyServlet class is a servlet that processes the addition of money to the user's account.
 */
@WebServlet(name = "ProcessAddMoneyServlet", urlPatterns = {"/ProcessAddMoneyServlet"})
public class ProcessAddMoneyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        double amountToAdd = Double.parseDouble(request.getParameter("amount"));

        if (userId == null || amountToAdd <= 0) {
            response.sendRedirect("views/login.jsp");
            return;
        }

        DataSource dataSource = new DataSource(getServletContext());
        try (Connection connection = dataSource.getConnection()) {
            UserAccountBusinessLogic userAccountBusinessLogic = new UserAccountBusinessLogic(connection);
            UserAccountDTO userAccountDTO = userAccountBusinessLogic.getUserAccountById(userId);
            double newBalance = userAccountDTO.getBalance()+amountToAdd;
           userAccountDTO.setBalance(newBalance);
           userAccountBusinessLogic.updateUserAccount(userAccountDTO);

            session.setAttribute("userBalance", newBalance);
            session.setAttribute("userId", userId);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/CustomerView.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error occurred");
        }
    }
}
