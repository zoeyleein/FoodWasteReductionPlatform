package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "PaymentServlet", urlPatterns = {"/PaymentServlet"})
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Integer customerId = (Integer) session.getAttribute("userId");
        System.out.println("Customer id is " + customerId);
        if (customerId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        request.getParameterMap().forEach((paramName, paramValues) -> {
            System.out.println(paramName + ": " + String.join(", ", paramValues));
        });

        String[] retailerInventoryIDs = request.getParameterValues("retailerInventoryIDs");
        String[] quantities = request.getParameterValues("quantities");

        HashMap<Integer, Integer> transactionDetails = new HashMap<>();

        if (retailerInventoryIDs != null && quantities != null) {
            for (int i = 0; i < retailerInventoryIDs.length; i++) {
                int id = Integer.parseInt(retailerInventoryIDs[i]);
                int qty = Integer.parseInt(quantities[i]);
                transactionDetails.put(id, qty);
            }
        }

        transactionDetails.forEach((key, value) -> System.out.println("ID: " + key + ", Qty: " + value));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/CustomerView.jsp");
        dispatcher.forward(request, response);
    }
}
