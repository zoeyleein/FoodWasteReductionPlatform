package controller;

import businesslayer.UserAccountBusinessLogic;
import dataaccesslayer.DataSource;
import model.CharityWorker;
import model.LogInValidation;
import transferobjects.InventoryItemDTO;
import transferobjects.UserAccountDTO;
import transferobjects.UserDTO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 * @author aaronthomp
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        dataSource = new DataSource(context);
    }
    LogInValidation logInValidation = new LogInValidation();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        if(Objects.equals(action, "Sign in")){
        try (Connection connection = dataSource.getConnection()) {
            UserDTO user = logInValidation.getUserRoleAndId(username, password, connection);
            if (user != null) {
                HttpSession session = request.getSession();
                String nextPage = logInValidation.logInPageRedirect(action, user.getRole());
                session.setAttribute("userId", user.getId());
                session.setAttribute("userRole", user.getRole());
                if(user.getRole().equals("Customer")){
                    UserAccountBusinessLogic userAccountBusinessLogic = new UserAccountBusinessLogic(connection);
                    System.out.println("User id is "+userAccountBusinessLogic.getUserAccountById(user.getId()));
                    if(userAccountBusinessLogic.getUserAccountById(user.getId())==null){
                        UserAccountDTO userAccountDTO = new UserAccountDTO();
                        userAccountDTO.setUsersId(user.getId());
                        userAccountDTO.setBalance(100);
                        userAccountBusinessLogic.addUserAccount(userAccountDTO);
                    }
                    UserAccountDTO userAccountDTO = userAccountBusinessLogic.getUserAccountById(user.getId());
                    double balance = userAccountDTO.getBalance();
                    session.setAttribute("userBalance", balance);
                }
                if (user.getRole().equals("Retailer")) {
                    session = request.getSession();
                    session.setAttribute("userId", user.getId());
                }else if(user.getRole().equals("Charity")){
                    CharityWorker worker = new CharityWorker();
                    List<InventoryItemDTO> items = worker.displayCharityClaims(connection);
                    session = request.getSession();
                    session.setAttribute("items", items);
                }

                response.sendRedirect(nextPage);
            }
            else {
                response.sendRedirect("views/SignInError.jsp");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        }else {
            response.sendRedirect("views/register/role_selection.jsp");
        }


    }

}
