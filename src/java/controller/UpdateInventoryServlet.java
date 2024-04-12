/**
 * This servlet handles the updating of inventory for a retailer.
 */
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


    /**
     * Initializes the servlet by setting up the data source.
     *
     * @throws ServletException if an error occurs during initialization
     */
    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        dataSource = new DataSource(context);
    }

    /**
     * Handles HTTP POST requests for updating inventory.
     *
     * @param request  the {@link HttpServletRequest} object
     * @param response the {@link HttpServletResponse} object
     * @throws ServletException if an error occurs while handling the request
     * @throws IOException      if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        int retailId = (int) request.getSession().getAttribute("userId");
        String name = request.getParameter("productName");
        int batchNum = Integer.parseInt(request.getParameter("batchNum"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        boolean sale = Boolean.parseBoolean(request.getParameter("sale")); // Retrieve sale from request parameters
        boolean donation = Boolean.parseBoolean(request.getParameter("donation")); // Retrieve donation from request parameters

        try (Connection connection = dataSource.getConnection()) {
            if(worker.productAlreadyExists(connection, retailId, name, batchNum)) {
                worker.updateQuantity(connection, retailId, name, batchNum, quantity, sale, donation);
                request.setAttribute("message", "Item updated successfully");
                request.setAttribute("messageColor", "green");
            }
            else{
                request.setAttribute("message", "Item does not exist, cannot update it");
                request.setAttribute("messageColor", "red");
            }
            request.getRequestDispatcher("views/UpdateInventory.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
