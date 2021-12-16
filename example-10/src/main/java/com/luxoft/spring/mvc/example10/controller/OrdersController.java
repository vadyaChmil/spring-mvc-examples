package com.luxoft.spring.mvc.example10.controller;

import com.luxoft.spring.mvc.example10.domain.Order;
import com.luxoft.spring.mvc.example10.domain.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        return "orderView";                     // this is logical view name corresponds to 'orderView.html' template
    }

    @RequestMapping("/simplepage")              // you may do not return view name if you render page manually
    public void simplePage(
        HttpServletResponse response
    ) throws IOException {
        response.getWriter().write(
            "<html><head></head><body>Hello!</body></html>"
        );
    }

    // TODO: run application and open this URL in browser

    @RequestMapping("/orderJson")              // if you want to return JSON, you can do this with @ResponseBody
    public @ResponseBody Order viewOrderJson(
        @RequestParam String id
    ) throws IOException {
        return repo.get(id);
    }

    // TODO: run application and open this URL in browser

    @RequestMapping("/ping")                   // if you want to return status codes - use ResponseEntity
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok("OK");
    }

    // TODO: run application and open this URL in browser

    @RequestMapping("/myerror")                // if you want to return status codes - use ResponseEntity
    public ResponseEntity<String> error(){
        // TODO: see other ResponseEntity methods, try to build other error
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");
    }
}
