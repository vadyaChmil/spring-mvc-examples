package com.luxoft.spring.mvc.example12.controller;

import com.luxoft.spring.mvc.example12.domain.Order;
import com.luxoft.spring.mvc.example12.domain.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Spring MVC Controller for order page
 */
@Controller
public class OrdersController {

    private final OrdersRepository repo;

    @Autowired
    public OrdersController(OrdersRepository repo) {
        this.repo = repo;
    }

    @RequestMapping("/order")
    public String viewOrder(
        @RequestParam String id,
        Model model
    ) {
        Order order = repo.get(id);
        model.addAttribute("order", order);
        return "orderView";
    }
}
