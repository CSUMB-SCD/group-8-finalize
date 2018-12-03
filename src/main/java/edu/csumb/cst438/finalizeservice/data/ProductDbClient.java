package edu.csumb.cst438.finalizeservice.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import edu.csumb.cst438.finalizeservice.api.products.Product;

@Repository
public class ProductDbClient {
    
    public List<Product> getAll(){
        final String uri = "https://proj-zuul.herokuapp.com/productdb/Product/";

        RestTemplate restTemplate = new RestTemplate();
        List<Product> result = restTemplate.getForObject(uri, ArrayList.class);
    
        return result;
    }

    public boolean setCredits(String uid) {
        return false;
    }

    static class reduceStockPayload {
        public String id;
        public int amount;
        reduceStockPayload(String id, int amount){
            this.id = id;
            this.amount = amount;
        }
    }
    public boolean reduceStock(String pid, int amount) {
        final String uri = "https://proj-zuul.herokuapp.com/productdb/removeStock/";

        RestTemplate restTemplate = new RestTemplate();
        
        HttpEntity<reduceStockPayload> request = new HttpEntity<>(new reduceStockPayload(pid, amount));
        Boolean result = restTemplate.postForEntity(uri, request, Boolean.class).getBody();
    
        return result;
    }
}