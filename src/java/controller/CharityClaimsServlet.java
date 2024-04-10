package controller;

import dataaccesslayer.DataSource;
import model.CharityWorker;
import transferobjects.InventoryItemDTO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CharityClaimsServlet", urlPatterns = {"/CharityClaimsServlet"})
public class CharityClaimsServlet extends HttpServlet {

    DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        dataSource = new DataSource(context);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CharityWorker worker = new CharityWorker();
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int claimedQuantity = Integer.parseInt(request.getParameter("claimedQuantity"));
        HttpSession session = request.getSession();

        try(Connection connection = dataSource.getConnection()) {
            boolean valid = worker.claimItem(connection, itemId, claimedQuantity);
            if(valid){
                List<InventoryItemDTO> items = worker.displayCharityClaims(connection);
                session.setAttribute("items", items);
                session.setAttribute("message", "Successfully claimed " + claimedQuantity + " items.");
            }else {
                session.setAttribute("error", "Claiming items failed. Please try again.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("views/CharityView.jsp");
    }


}
