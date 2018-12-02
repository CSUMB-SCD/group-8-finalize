package edu.csumb.cst438.finalizeservice.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}