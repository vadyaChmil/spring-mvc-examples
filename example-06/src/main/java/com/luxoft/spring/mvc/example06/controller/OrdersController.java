package com.luxoft.spring.mvc.example06.controller;

import com.luxoft.spring.mvc.example06.domain.Order;
import com.luxoft.spring.mvc.example06.domain.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Spring MVC Controller for order page
 */
@Controller
@RequestMapping("/orders")              // it specifies URL prefix for all handlers
public class OrdersController {

    private final OrdersRepository repo;

    @Autowired
    public OrdersController(OrdersRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(method = RequestMethod.GET)     // What is mapped URL?
    public String orders(Model model) {
        List<Order> orders = repo.getAll();
        model.addAttribute("orders", orders);
        return "ordersList";
    }

    @RequestMapping("/view")                        // Maps it to '/orders/view/'
    public String viewOrder(
            @RequestParam(value = "id") String id, Model model
    ) {
        Order order = repo.get(id);
        model.addAttribute("order", order);
        return "orderView";
    }

    @RequestMapping("/new/normal")                  // Maps it to '/orders/new/normal'
    public String newNormalOrder() {
        return "orderNew";
    }

    // TODO: run application and open each of these pages in browser
}
