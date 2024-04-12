package controller;

import businesslayer.UserAccountBusinessLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



/**
 * This class has the logic to display the user balance.
 */
@WebServlet(name = "AddMoneyServlet", urlPatterns = {"/AddMoneyServlet"})
public class AddMoneyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        Integer userId = null;
        double currentBal=0;
        try {
            userId = Integer.parseInt(request.getParameter("userId"));
            currentBal=Double.parseDouble(request.getParameter("currentBal"));
            System.out.println("User id is"+userId);
        } catch (NumberFormatException e) {
            response.sendRedirect("login.jsp"); // Redirect to login or error page if userID is not valid or not present
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("userId", userId); // Store userId in session for use in AddMoney.jsp
        session.setAttribute("currentBal",currentBal);
        response.sendRedirect("views/AddMoney.jsp");
    }
}

