package edu.csumb.cst438.finalizeservice.api;

import java.util.List;

import edu.csumb.cst438.finalizeservice.api.products.Product;
import edu.csumb.cst438.finalizeservice.api.users.User;

public class Payload {
    public User user;
    public List<Product> products;
}