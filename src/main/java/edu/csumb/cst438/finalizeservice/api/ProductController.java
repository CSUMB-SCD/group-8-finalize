package edu.csumb.cst438.finalizeservice.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.csumb.cst438.finalizeservice.api.products.Product;
import edu.csumb.cst438.finalizeservice.api.users.User;
import edu.csumb.cst438.finalizeservice.business.Manager;

@RestController
public class ProductController {
    @Autowired
    Manager manager;

    static class Payload{
        public User user;
        public List<Product> products;
        public List<Integer> amounts;
    }

    @CrossOrigin
    @RequestMapping(value="/process", method = RequestMethod.POST)
    public List<String> process(@RequestBody Payload payload) throws Exception {
        // TODO: this is very naive assuming the data is correct; in a perfect would we would confirm this info
        ArrayList<String> errors = new ArrayList<String>();
        double credits = payload.user.credits;

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
            // set credits
            // set stock
        } 
        return errors;
    }
    @CrossOrigin
    @RequestMapping(value="/test", method = RequestMethod.POST)
    public List<String> test(@RequestBody String payload) throws Exception {
        System.out.print("string");
        ArrayList<String> result = new ArrayList<String>();
        result.add(payload + "123");
        return result;
    }

    @GetMapping("/")
    public String home() {
        System.out.print("test");
        return "This is a trivial service that demonstrates how a Eureka Client can register with a Eureka Server";
    }
}