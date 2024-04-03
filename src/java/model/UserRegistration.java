package model;


/**
 * @author aaronthomp
 */
public class UserRegistration {

    public String registrationType(String userType){
        switch (userType) {
            case "Customer":
                return "views/register/Customer_registration.jsp";
            case "Retailer":
                return "views/register/Retailer_registration.jsp";
            case "Charity":
                return "views/register/Charity_registration.jsp";
            default:
                throw new IllegalArgumentException("Error: Unexpected user type");
        }
    }

    public boolean validate(String name, String email, String password, String phone, String location) {
        // add parameters to method signature as needed, currently we just ask for these though
        if (name == null || email == null || password == null || phone == null || location == null) {
            return false;
        } else {

        }
        return true;
    }
}
