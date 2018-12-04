package edu.csumb.cst438.finalizeservice.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.cst438.finalizeservice.api.Payload;
import edu.csumb.cst438.finalizeservice.api.products.Product;
import edu.csumb.cst438.finalizeservice.data.ProductDbClient;

@Service
public class Manager{
    @Autowired
    ProductDbClient productDbClient;

    public List<String> confirmPurchase(Payload payload) throws Exception {
        // TODO: this is very naive assuming the data is correct; in a perfect would we would confirm this info
        ArrayList<String> errors = new ArrayList<String>();
        double credits = payload.user.credit;

        double total = 0;
        boolean InsufficientStock = false;
        for (Product product : payload.products){
            if (product.stock < product.quantity){
                InsufficientStock = true;
            }
            total += product.price * product.quantity;
        }
        if (InsufficientStock){
            errors.add("Insufficient Stock");
        }
        if (total > credits){
            errors.add("Insufficient Funds");
        }
        if (errors.size() == 0){
            payload.user.credit -= total;
            productDbClient.setCredits(payload.user);
            for (Product product : payload.products){
                productDbClient.reduceStock(product, product.quantity);
            }
        }
        return errors;
    }
}