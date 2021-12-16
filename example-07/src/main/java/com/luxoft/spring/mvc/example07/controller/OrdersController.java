package com.luxoft.spring.mvc.example07.controller;

import com.luxoft.spring.mvc.example07.domain.Order;
import com.luxoft.spring.mvc.example07.domain.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/view/{orderId}")              // map to URLs like '/view/1'
    public String viewOrder(
        @PathVariable("orderId") String id,     // this parameter receives value from URL
        Model model
    ) {
        Order order = repo.get(id);
        model.addAttribute("order", order);
        return "orderView";
    }

    @RequestMapping("/**/orders")           // map to '/orders', '/anystring/orders/', '/any/path/orders/', etc
    public String orders(Model model) {
        List<Order> orders = repo.getAll();
        model.addAttribute("orders", orders);
        return "ordersList";
    }

    @RequestMapping("/new/*")                       // map to '/new/normal', '/new/complex'
    public String newNormalOrder() {
        return "orderNew";
    }

    @RequestMapping(                                // map to '/new' only GET HTTP method
        value = "/new",
        method = RequestMethod.GET
    )
    public String newGet() {
        return "orderNew";
    }

    @RequestMapping(                                // map to '/new1', '/new2' only GET and POST HTTP methods
        value = {"/new1", "new2"},
        method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String multipleNew() {
        return "orderNew";
    }

    @GetMapping("/newget")                          // map to '/newget', GET method
    public String newWithMethodAnnotations() {
        return "orderNew";
    }
}
