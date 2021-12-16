package com.luxoft.spring.mvc.example08.domain;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Orders repository
 */
@Service
public class OrdersRepository {

    private final List<Order> orders = new ArrayList<>();

    public OrdersRepository() {
        orders.add(new Order("1", "Luxoft", 100.0));
        orders.add(new Order("2", "IBM", 200.0));
    }

    public Order get(String id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getAll() {
        return orders;
    }
}
