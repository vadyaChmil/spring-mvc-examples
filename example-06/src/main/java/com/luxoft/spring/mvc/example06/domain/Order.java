package com.luxoft.spring.mvc.example06.domain;

/**
 * Order class
 */
@SuppressWarnings("all")
public class Order {
    private String id;
    private String customer;
    private double amount;

    public Order(String id, String customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }
}
