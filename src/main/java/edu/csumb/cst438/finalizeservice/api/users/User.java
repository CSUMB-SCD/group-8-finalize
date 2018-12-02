package edu.csumb.cst438.finalizeservice.api.users;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    public String id;

    public String name;
    public String password;
    public double credits;

    public User() {}

    public User(String name, String password, double credits) {
        this.name = name;
        this.password = password;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return name;
    }

}