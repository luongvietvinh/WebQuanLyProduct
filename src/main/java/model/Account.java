package model;

public class Account {
    private int idaccount;
    private String username;
    private String passwords;
    private String email;
    private String phone;
    private String address;
    private int idrole;

    public Account(int idaccount, String username, String passwords,
                   String email, String phone, String address, int idrole) {
        this.idaccount = idaccount;
        this.username = username;
        this.passwords = passwords;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.idrole = idrole;
    }

    public Account(String username, String passwords, String email, String phone, String address) {
        this.username = username;
        this.passwords = passwords;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(int idaccount) {
        this.idaccount = idaccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

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

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
