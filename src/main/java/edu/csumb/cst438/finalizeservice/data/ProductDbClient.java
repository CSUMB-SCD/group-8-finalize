package edu.csumb.cst438.finalizeservice.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import edu.csumb.cst438.finalizeservice.api.Payload;
import edu.csumb.cst438.finalizeservice.api.reduceStockPayload;
import edu.csumb.cst438.finalizeservice.api.products.Product;
import edu.csumb.cst438.finalizeservice.api.users.User;

@Repository
public class ProductDbClient {
    
    public List<Product> getAll(){
        final String uri = "https://proj-zuul.herokuapp.com/productdb/Product/";

        RestTemplate restTemplate = new RestTemplate();
        List<Product> result = restTemplate.getForObject(uri, ArrayList.class);
    
        return result;
    }

    public void setCredits(User user) {
        final String uri = "https://proj-zuul.herokuapp.com/userdb/setCredits/";

        RestTemplate restTemplate = new RestTemplate();
        
        restTemplate.postForEntity(uri, user, Object.class);
    }
    
    public void reduceStock(Product product, int amount) {
        final String uri = "https://proj-zuul.herokuapp.com/productdb/removeStock/";

        RestTemplate restTemplate = new RestTemplate();
        
        reduceStockPayload payload = new reduceStockPayload(product, amount);
        restTemplate.postForEntity(uri, payload, Object.class);
    }
}