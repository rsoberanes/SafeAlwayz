package com.studios.primitive.safealwayz.ui.main.Account;

import java.io.Serializable;

public class AccountModel implements Serializable {
    private String userName;
    private String password;
    private String email;
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    //Constructor


    public AccountModel(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public AccountModel(){

    }
    //toString

    @Override
    public String toString() {
        return "AccountModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    //Getter and Setters


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
