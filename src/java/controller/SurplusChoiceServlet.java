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

@WebServlet(name = "SurplusChoiceServlet", urlPatterns = {"/SurplusChoiceServlet"})
public class SurplusChoiceServlet extends HttpServlet {
    DataSource dataSource;
    RetailerInventoryWorker worker = new RetailerInventoryWorker();

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        dataSource = new DataSource(context);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        int itemId = (int) request.getSession().getAttribute("itemId");

        try (Connection connection = dataSource.getConnection()) {
            switch (action) {
                case "Sale" -> worker.updateInventoryFlags(connection, itemId, true, false);
                case "Donation" -> worker.updateInventoryFlags(connection, itemId, false, true);
                case "Both" -> worker.updateInventoryFlags(connection, itemId, true, true);
            }

        } catch(SQLException e) {
            throw new ServletException(e);
        }
        response.sendRedirect("views/RetailerView.jsp");
    }
}
