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

        if (payload.products.size() != payload.amounts.size()){
            throw new Exception();
        }
        double total = 0;
        boolean InsufficientStock = false;
        for (int i = 0; i < payload.products.size(); i++){
            total += payload.products.get(i).price * payload.amounts.get(i);
            if (payload.products.get(i).stock < payload.amounts.get(i)){
                InsufficientStock = true;
            }
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
            for (int i = 0; i < payload.products.size(); i++){
                productDbClient.reduceStock(payload.products.get(i), payload.amounts.get(i));
            }
        }
        return errors;
    }
}