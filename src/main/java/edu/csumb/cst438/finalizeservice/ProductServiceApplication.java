package edu.csumb.cst438.finalizeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class ProductServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
    }
}
