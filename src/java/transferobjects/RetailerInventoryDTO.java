package transferobjects;

import java.util.Date;

public class RetailerInventoryDTO {
    private int id;
    private int usersId;
    private int itemId;
    private int batch;
    private Date expiryDate;
    private int quantity;
    private double unitPrice;
    private double finalPrice;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUsersId() {
        return usersId;
    }
    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public int getBatch() {
        return batch;
    }
    public void setBatch(int batch) {
        this.batch = batch;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public double getFinalPrice() {
        return finalPrice;
    }
    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
