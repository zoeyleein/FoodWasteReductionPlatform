package model;



/**
 * @author aaronthomp
 */
public class UserRegistration {

    public String welcomePageRedirect(String action){
        if (action.equals("Log In")) {
            return "views/Signin.jsp";
        } else if (action.equals("Sign Up")) {
            return "views/register/role_selection.jsp";
        } else {
            throw new IllegalArgumentException("Error: Unexpected outcome");
            // if we have a different action, we can redirect to an error page
        }
    }


    public String registrationType(String userType){
        return switch (userType) {
            case "Customer" -> "views/register/Customer_registration.jsp";
            case "Retailer" -> "views/register/Retailer_registration.jsp";
            case "Charity" -> "views/register/Charity_registration.jsp";
            default -> throw new IllegalArgumentException("Error: Unexpected user type");
        };
    }


}
