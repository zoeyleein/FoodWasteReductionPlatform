package model;
public class User {
    private int id;
    private String name;
    private String password;
    private String role;
    private String location;

    // Constructors
    public User() {
    }

    public User(String name, String password, String role, String location) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.location = location;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
