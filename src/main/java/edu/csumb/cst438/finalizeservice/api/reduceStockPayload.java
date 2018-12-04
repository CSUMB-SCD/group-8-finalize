package edu.csumb.cst438.finalizeservice.api;

import java.util.List;

import edu.csumb.cst438.finalizeservice.api.products.Product;
import edu.csumb.cst438.finalizeservice.api.users.User;

public class reduceStockPayload {

    public Product product;
    public Integer amount;

    public reduceStockPayload(Product product, int amount){
        this.product = product;
        this.amount = amount;
    }
}