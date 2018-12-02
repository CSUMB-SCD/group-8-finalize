package edu.csumb.cst438.finalizeservice.api.products;

import org.springframework.data.annotation.Id;

public class Manufacturer {

    @Id
    public String id;

    public String name;
    public String description;


    public Manufacturer() {}

    public Manufacturer(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return null;
    }

}