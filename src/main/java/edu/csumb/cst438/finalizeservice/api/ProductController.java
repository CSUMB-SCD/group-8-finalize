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

    @CrossOrigin
    @RequestMapping(value="/process", method = RequestMethod.POST)
    public List<String> confirmPurchase(@RequestBody Payload payload) throws Exception {
        return manager.confirmPurchase(payload);
        
    }
    
    @CrossOrigin
    @RequestMapping(value="/test", method = RequestMethod.POST)
    public List<String> test(@RequestBody String payload) throws Exception {
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