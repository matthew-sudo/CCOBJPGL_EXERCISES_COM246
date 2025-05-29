package com.example;

import javafx.beans.property.SimpleStringProperty;

public class User {
    private final SimpleStringProperty username;
    private final SimpleStringProperty password;
    private final SimpleStringProperty accountcreated;
    private final SimpleStringProperty accountstatus;

    public User(String uname, String pword, String dcreated, String acstatus) {
        this.username = new SimpleStringProperty(uname);
        this.password = new SimpleStringProperty(pword);
        this.accountcreated = new SimpleStringProperty(dcreated);
        this.accountstatus = new SimpleStringProperty(acstatus);
    }

    public String getUsername() {
        return username.get();
    }

    public String getPassword() {
        return password.get();
    }

    public String getAccountCreated() {
        return accountcreated.get();
    }

    public String getAccountStatus() {
        return accountstatus.get();
    }
}