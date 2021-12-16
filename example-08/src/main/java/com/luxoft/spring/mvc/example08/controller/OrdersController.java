package com.luxoft.spring.mvc.example08.controller;

import com.luxoft.spring.mvc.example08.domain.Order;
import com.luxoft.spring.mvc.example08.domain.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @RequestMapping(value = "/view", params = "orderId")        // map to /view if 'orderId' param is present
    public String viewOrder(
        @RequestParam("orderId") String id,
        Model model
    ) {
        Order order = repo.get(id);
        model.addAttribute("order", order);
        return "orderView";
    }

    @RequestMapping(value = "/view", params = "!orderId")       // map to /view if 'orderId' param is not present
    public String viewDefaultOrder(
        Model model
    ) {
        Order order = repo.get("1");
        model.addAttribute("order", order);
        return "orderView";
    }

    @RequestMapping(                                            // if user open this URL in browser
        value = "/orders",
        headers = "Accept=text/html"
    )
    public String orders(Model model) {
        List<Order> orders = repo.getAll();
        model.addAttribute("orders", orders);
        return "ordersList";
    }

    @RequestMapping(                                            // if user wants JSON
        value = "/orders",
        headers = "Accept=application/json"
    )
    public String ordersJson(Model model) {
        List<Order> orders = repo.getAll();
        model.addAttribute("orders", orders);
        return "ordersList";
    }
}
