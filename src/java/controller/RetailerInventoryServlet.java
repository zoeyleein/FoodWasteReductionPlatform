package controller;

import dataaccesslayer.DataSource;
import dataaccesslayer.ItemDAOImpl;
import dataaccesslayer.RetailerInventoryDAOImpl;
import model.DTOBuilder;
import model.RetailerInventoryWorker;
import transferobjects.ItemDTO;
import transferobjects.RetailerInventoryDTO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RetailerInventoryServlet", urlPatterns = {"/RetailerInventoryServlet"})
public class RetailerInventoryServlet extends HttpServlet {
    int retailId;
    int itemId;
    String itemName;
    String itemCategory;
    int rInventoryBatchNum;
    int rInventoryQuantity;
    double rInventoryUnitPrice;
    double rInventoryFinalPrice;
    Date rInventoryExpDate;
    RetailerInventoryWorker worker = new RetailerInventoryWorker();
    DTOBuilder builder = new DTOBuilder();

    DataSource dataSource;
    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        dataSource = new DataSource(context);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        retailId = (int) request.getSession().getAttribute("userId");
        itemName = request.getParameter("productName");
        itemCategory = request.getParameter("category");
        rInventoryBatchNum = Integer.parseInt(request.getParameter("batch"));
        rInventoryQuantity = Integer.parseInt(request.getParameter("quantity"));
        rInventoryUnitPrice = Double.parseDouble(request.getParameter("price"));
        String expiryDateStr = request.getParameter("expiryDate");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            rInventoryExpDate = formatter.parse(expiryDateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int productStatus = worker.productStatus(rInventoryExpDate); // determine how close to expiry we are
        rInventoryFinalPrice = worker.productPrice(productStatus, rInventoryUnitPrice);
        ItemDTO item = builder.itemBuilder(itemName, itemCategory);
        // still need to deal with button clicks, any button just adds rn
        try (Connection connection = dataSource.getConnection()) {
            itemId = worker.insertAndGetGeneratedId(connection, item);
            RetailerInventoryDTO retailInventory = builder.retailerInventoryBuilder(retailId, itemId, rInventoryBatchNum, rInventoryQuantity, rInventoryUnitPrice, rInventoryFinalPrice, rInventoryExpDate);
            RetailerInventoryDAOImpl retailerInventoryDAO = new RetailerInventoryDAOImpl(connection);
            retailerInventoryDAO.insertRetailerInventory(retailInventory);
            response.sendRedirect("view/RetailerView.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
