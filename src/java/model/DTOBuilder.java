package model;

/*
@author aaronthomp
 */

import transferobjects.UserDTO;

public class DTOBuilder {

    public UserDTO userBuilder(String name, String password, String role, String email, String phone, String location){
        UserDTO user = new UserDTO();
        user.setName(name);
        user.setPassword(password);
        user.setRole(role);
        user.setMail(email);
        user.setPhone(phone);
        user.setLocation(location);
        return user;
    }
}
