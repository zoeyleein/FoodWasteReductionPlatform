package transferobjects;

import java.util.Date;

public class InventoryItemDTO {
    private String name;
    private String category;
    private int quantity;
    private Date expiryDate;
    private double finalPrice;
    private boolean sale;
    private boolean donation;

    public InventoryItemDTO(String name, String category, int quantity, Date expiryDate, double finalPrice, boolean sale, boolean donation) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.finalPrice = finalPrice;
        this.sale = sale;
        this.donation = donation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public boolean isSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }

    public boolean isDonation() {
        return donation;
    }

    public void setDonation(boolean donation) {
        this.donation = donation;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", expiryDate=" + expiryDate +
                ", finalPrice=" + finalPrice +
                ", sale=" + sale +
                ", donation=" + donation;
    }

}
