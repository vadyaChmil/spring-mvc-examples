package com.luxoft.spring.mvc.example10.controller;

import com.luxoft.spring.mvc.example10.domain.Order;
import com.luxoft.spring.mvc.example10.domain.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Spring MVC Controller for orders
 */
@RestController                                 // This annotation means @Controller + @ResponseBody on each handler
public class OrdersRestController {

    private final OrdersRepository repo;

    @Autowired
    public OrdersRestController(OrdersRepository repo) {
        this.repo = repo;
    }

    @RequestMapping("/rest/orderJson")          // @ResponseBody here is redundant
    public Order viewOrder(
        @RequestParam String id
    ) throws IOException {
        return repo.get(id);
    }

    @PostMapping("/rest/new")                   // POST with '{"id":1, "customer":"Micro", "amount":1}' body
    public void newOrderJson(
        @RequestBody Order order                // But @RequestBody is mandatory to receive JSON
    ) {
        repo.add(order);
    }
}
