package model;


import java.util.Objects;

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
        if (Objects.equals(name, "") || Objects.equals(email, "")
                || Objects.equals(password, "") || Objects.equals(phone, "") || Objects.equals(location, "")) {
            // we may need to change the validation requirements, currently the above is useless since you
            // can't submit the form without filling out all the fields
            return false;
        } else {
            // not sure what to put here
        }
        return true;
    }
}
