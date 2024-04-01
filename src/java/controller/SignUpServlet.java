package controller;

import model.Charities;
import model.Consumer;
import model.Retailer;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType = request.getParameter("role");
        User user = createUserBasedOnType(userType);

        // Set common attributes
        user.setName(request.getParameter("name"));
        user.setRole(request.getParameter("role"));
        user.setPassword(request.getParameter("password")); // if possible this data should be hidden and/or encrypted idk how to do that yet
        // maybe for security purposes password is separate to each page so it does not have to be carried over into the next page in the session
        // HttpSession session = request.getSession();
        // User user = (User) session.getAttribute("currentUser"); <-> code to get the previously stored object from the session

        // idk how this works yet but go to separate jsp pages based on user type
        if (user instanceof Consumer) { // if (button="consumer") then go to consumerSignUp.jsp
            request.getRequestDispatcher("consumer.jsp").forward(request, response);
        } else if (user instanceof Retailer) {
            request.getRequestDispatcher("retailer.jsp").forward(request, response);
        } else if (user instanceof Charities) {
            request.getRequestDispatcher("charities.jsp").forward(request, response);
        } // copilot suggested the above code so i dont know if it works but the idea is to redirect to a different page based on user type
//We will have a factory to manage the role type and create an instance of each accordingly
        // then save the user (to the database, session, etc.) once they have typed in all the new info


    }


    private User createUserBasedOnType(String role) {
        switch (role) {
            case "Consumer":
                return new Consumer();
            case "Retailer":
                return new Retailer();
            case "Charity":
                return new Charities();
            default:
                throw new IllegalArgumentException("Invalid user type: " + role);
        }
    }
}
