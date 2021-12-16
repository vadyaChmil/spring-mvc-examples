package com.luxoft.spring.mvc.example04.controller;

import com.luxoft.spring.mvc.example04.domain.Order;
import com.luxoft.spring.mvc.example04.domain.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Spring MVC Controller for order page
 */
@Controller // This annotation means that this class will receive HTTP requests
public class OrdersController {

    private final OrdersRepository repo;

    @Autowired
    public OrdersController(OrdersRepository repo) {
        this.repo = repo;
    }

    @RequestMapping("/order")                // maps URLs like 'http://localhost:8080/order?id=1' to this method
    public String viewOrder(
        @RequestParam(value = "id")
            String id,                       // parameter from HTTP request
        Model model                          // Model object to store page model
    ) {
        Order order = repo.get(id);
        model.addAttribute("order", order);  // stores order in the model with the "order" key

        return "orderView";            // logical view name, corresponds to 'src/resources/templates/orderView.html
    }

    // TODO: run this application using IDE
    // TODO: open 'http://localhost:8080/order?id=1' in your browser.
    // TODO: modify @RequestMapping path, and test it in your browser
}
