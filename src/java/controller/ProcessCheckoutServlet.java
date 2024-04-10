package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProcessCheckoutServlet", value = "/ProcessCheckoutServlet")
public class ProcessCheckoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Item> items = new ArrayList<>();
        double totalCost = 0.0;

        try {
            String[] itemParams = request.getParameterValues("items[].");
            if (itemParams == null) {
                throw new IllegalArgumentException("No items found in the request.");
            }

//
//            for(String s: itemParams){
//                System.out.println(s);
//            }


            int itemsPerEntry = 6;
            for (int i = 0; i < itemParams.length; i += itemsPerEntry) {
                String itemName = itemParams[i];
                String expiryDate = itemParams[i + 1];
                boolean onSale = "true".equals(itemParams[i + 2]);
                double unitPrice = Double.parseDouble(itemParams[i + 3]);
                int quantityPurchased = Integer.parseInt(itemParams[i + 4]);
                double cost = Double.parseDouble(itemParams[i + 5]);

                Item item = new Item(itemName, expiryDate, onSale, unitPrice, quantityPurchased, cost);
                items.add(item);
                System.out.println(itemName + " " + onSale);

                totalCost += cost;
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request: No items found.");
            return;
        }

        request.setAttribute("items", items);
        request.setAttribute("totalCost", totalCost);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/checkoutSummary.jsp");
        dispatcher.forward(request, response);
    }

    public static class Item {
        private String itemName;
        private String expiryDate;
        private boolean onSale;
        private double unitPrice;
        private int quantityPurchased;
        private double totalCost;

        public Item(String itemName, String expiryDate, boolean onSale, double unitPrice, int quantityPurchased, double totalCost) {
            this.itemName = itemName;
            this.expiryDate = expiryDate;
            this.onSale = onSale;
            this.unitPrice = unitPrice;
            this.quantityPurchased = quantityPurchased;
            this.totalCost = totalCost;
        }

        public String getItemName() { return itemName; }
        public String getExpiryDate() { return expiryDate; }
        public boolean isOnSale() { return onSale; }
        public double getUnitPrice() { return unitPrice; }
        public int getQuantityPurchased() { return quantityPurchased; }
        public double getTotalCost() { return totalCost; }
    }
}
