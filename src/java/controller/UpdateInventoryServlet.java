package controller;


import dataaccesslayer.DataSource;
import model.RetailerInventoryWorker;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "UpdateInventoryServlet", urlPatterns = {"/UpdateInventoryServlet"})
public class UpdateInventoryServlet extends HttpServlet {
    RetailerInventoryWorker worker = new RetailerInventoryWorker();
    DataSource dataSource;


    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        dataSource = new DataSource(context);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        int retailId = (int) request.getSession().getAttribute("userId");
        String name = request.getParameter("productName");
        int batchNum = Integer.parseInt(request.getParameter("batchNum"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try (Connection connection = dataSource.getConnection()) {
            worker.updateQuantity(connection, retailId, name, batchNum, quantity);
            response.sendRedirect("views/UpdateInventory.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
