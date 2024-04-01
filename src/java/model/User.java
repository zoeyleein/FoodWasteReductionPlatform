package model;
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String userType;
    private String role;
    private String phone;
    private String location;
    private double balance;

    // Constructors
    public User() {
    }

    public User(String name, String email, String password, String role, String phone, String location, double balance) {
        this.id = id;
        this.name = name;
        this.email = email; //delete
        this.password = password;
        this.userType = userType;
        this.role = role; //delete
        this.phone = phone;//delete
        this.location = location;//delete
        this.balance = balance;//delete
        this.role = role;
        this.phone = phone;
        this.location = location;
        this.balance = balance;

    }

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getUserType() {
//        return userType;
//    }
//
//    public void setUserType(String userType) {
//        this.userType = userType;
//    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Additional methods
    public void register() {
        // Implement registration logic here
    }

    public boolean login() {
        // Implement login logic here
        return false; // Placeholder return, replace with actual logic
    }

    public void logout() {
        // Implement logout logic here
    }
}
