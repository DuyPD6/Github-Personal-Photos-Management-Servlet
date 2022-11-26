/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author bunny
 */
public class Account {
    private String username;
    private String password;
    private String phone;
    private String role;
    private String email;

    public Account() {
    }

    public Account(String username, String password, String phone, String role, String email) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", phone=" + phone + ", role=" + role + ", email=" + email + '}';
    }

    
}
