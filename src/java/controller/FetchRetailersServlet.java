package controller;

import businesslayer.ShowRetailersAtLocationBusinessLogic;
import transferobjects.UserDTO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FetchRetailersServlet", urlPatterns = {"/FetchRetailersServlet"})
public class FetchRetailersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String location = request.getParameter("location").toLowerCase();
        System.out.println(location);
        ShowRetailersAtLocationBusinessLogic logic = new ShowRetailersAtLocationBusinessLogic();

        try {
            ServletContext context = getServletContext();
            ArrayList<UserDTO> retailerNames = logic.getRetailersAtLocations(location, context);
            for(UserDTO users: retailerNames){
                System.out.println(users.getLocation());
            }
            request.setAttribute("retailerNames", retailerNames);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle error
        }

        // Forward to a JSP page to display the retailer names
        request.getRequestDispatcher("views/showRetailersAtLocation.jsp").forward(request, response);
    }
}
