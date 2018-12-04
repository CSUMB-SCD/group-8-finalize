package edu.csumb.cst438.finalizeservice.api.users;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    public String id;

    public String username;
    public String password;
    public double credit;

    public User() {}

    public User(String username, String password, double credit) {
        this.username = username;
        this.password = password;
        this.credit = credit;
    }

    @Override
    public String toString() {
        return username;
    }

}