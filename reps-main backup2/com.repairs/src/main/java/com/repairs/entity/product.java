package com.repairs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    private String productName;

    public product(String productName) {
        this.productName = productName;
    }

    public product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
