package model;

/*
@author aaronthomp
 */

import transferobjects.ItemDTO;
import transferobjects.RetailerInventoryDTO;
import transferobjects.UserDTO;

import java.util.Date;

public class DTOBuilder {

    public UserDTO userBuilder(String name, String password, String role, String email, String phone, String location, Boolean subscribeToPhone, Boolean subscribeToEmail){
        UserDTO user = new UserDTO();
        user.setName(name);
        user.setPassword(password);
        user.setRole(role);
        user.setMail(email);
        user.setPhone(phone);
        user.setLocation(location);
        user.setSubscribeToEmail(subscribeToEmail);
        user.setSubscribeToPhone(subscribeToPhone);
        return user;
    }

    public ItemDTO itemBuilder(String itemName, String itemCategory){
        ItemDTO item = new ItemDTO();
        item.setName(itemName);
        item.setCategory(itemCategory);
        return item;
    }


    public RetailerInventoryDTO retailerInventoryBuilder(int retailId, int itemId, int rInventoryBatchNum, int rInventoryQuantity, double rInventoryUnitPrice, double rInventoryFinalPrice, Date rInventoryExpDate, boolean sale, boolean donation){
        RetailerInventoryDTO retailerInventory = new RetailerInventoryDTO();
        retailerInventory.setUsersId(retailId);
        retailerInventory.setItemId(itemId);
        retailerInventory.setBatch(rInventoryBatchNum);
        retailerInventory.setQuantity(rInventoryQuantity);
        retailerInventory.setUnitPrice(rInventoryUnitPrice);
        retailerInventory.setFinalPrice(rInventoryFinalPrice);
        retailerInventory.setExpiryDate(rInventoryExpDate);
        retailerInventory.setSale(sale);
        retailerInventory.setDonation(donation);
        return retailerInventory;
    }
}