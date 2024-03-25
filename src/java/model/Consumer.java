package model;

public class Consumer extends User{
    String email;
    String phone;
    boolean subscribeByMail;
    boolean subscribeByPhone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSubscribeByMail() {
        return subscribeByMail;
    }

    public void setSubscribeByMail(boolean subscribeByMail) {
        this.subscribeByMail = subscribeByMail;
    }

    public boolean isSubscribeByPhone() {
        return subscribeByPhone;
    }

    public void setSubscribeByPhone(boolean subscribeByPhone) {
        this.subscribeByPhone = subscribeByPhone;
    }
}
