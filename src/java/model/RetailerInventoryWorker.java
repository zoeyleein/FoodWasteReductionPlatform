package model;

import transferobjects.ItemDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class RetailerInventoryWorker {

    int NOT_FOR_SALE = 0;
    int ON_SALE = 1;
    int FOR_DONATION = 2;
    int EXPIRED = 3;
    double salePercent = 0.3;

    public boolean expiryDateValidation(Date expiryDate) {
        Date currentDate = new Date();

        long differenceInMillis = expiryDate.getTime() - currentDate.getTime();
        long daysDifference = differenceInMillis / (1000 * 60 * 60 * 24);

        return daysDifference <= 7;
    }

    public boolean isDonation(Date expiryDate){
        Date currentDate = new Date();
        long differenceInMillis = expiryDate.getTime() - currentDate.getTime();
        long daysDifference = differenceInMillis / (1000 * 60 * 60 * 24);
        return daysDifference <= 3;
    }

    public boolean isExpired(Date expiryDate){
        Date currentDate = new Date();
        long differenceInMillis = expiryDate.getTime() - currentDate.getTime();
        long daysDifference = differenceInMillis / (1000 * 60 * 60 * 24);
        return daysDifference <= 0;
    }

    public int productStatus(Date expiryDate){
        if (isExpired(expiryDate)){
            return EXPIRED;
        } else if (isDonation(expiryDate)){
            return FOR_DONATION;
        } else if (expiryDateValidation(expiryDate)){
            return ON_SALE;
        } else {
            return NOT_FOR_SALE;
        }
    }

    public double productPrice(int status, double unitPrice) {
        if (status == ON_SALE){
            return (unitPrice - (unitPrice * salePercent));
        } else {
            return unitPrice;
        }
    }





    public int insertAndGetGeneratedId(Connection connection, ItemDTO item) throws SQLException {
        String insertQuery = "INSERT INTO item VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, item.getId());
            pstmt.setString(2, item.getName());
            pstmt.setString(3, item.getCategory());
            pstmt.executeUpdate();
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1; // Return -1 if no generated key is retrieved
    }
    }

