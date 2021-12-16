package com.luxoft.spring.mvc.example09.controller;

import com.luxoft.spring.mvc.example09.domain.Order;
import com.luxoft.spring.mvc.example09.domain.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;

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

    @RequestMapping("/view1")
    public String viewOrderRequestParam1(
        @RequestParam("orderId") String id,                 // here is the sample of @RequestParam usage
        Model model
    ) {
        Order order = repo.get(id);
        model.addAttribute("order", order);
        return "orderView";
    }

    @RequestMapping("/view2")
    public String viewOrderRequestParam2(
        @RequestParam String id,                            // it means that param name is 'id'
        Model model
    ) {
        Order order = repo.get(id);
        model.addAttribute("order", order);
        return "orderView";
    }

    @RequestMapping("/viewMap")
    public String viewOrderRequestParamsMap(
        @RequestParam Map<String, String> params,           // map of all params
        Model model
    ) {
        String id = params.get("orderId");                  // get ID from map
        Order order = repo.get(id);
        model.addAttribute("order", order);
        return "orderView";
    }


    class NewOrderRequest {
        String id;
        String customer;
        double amount;
    }

    @GetMapping("/new")                                     // GET '/new?id=4&customer=Microsoft&amount=1'
    public String newOrderPojoParams(
        NewOrderRequest params,                             // POJO with all params
        Model model
    ) {
        String id = params.id;                              // ID from request string
        String customer = params.customer;                  // customer from request string
        double amount = params.amount;                      // amount from request string

        Order order = new Order(id, customer, amount);
        repo.add(order);

        model.addAttribute("order", order);
        return "orderView";
    }

    @PostMapping("/new")                                // POST '/new' with '{"id":1, "customer":"Micro", "amount":1}'
    public void newOrderJson(
        @RequestBody NewOrderRequest objectFromJson         // Object from JSON
    ) {
        Order order = new Order(
            objectFromJson.id,
            objectFromJson.customer,
            objectFromJson.amount
        );
        repo.add(order);
    }

    @RequestMapping("/viewModel")
    public String viewOrderWithModel(
        @RequestParam("orderId") String id,
        Model model                                         // Spring MVC creates model object
    ) {
        Order order = repo.get(id);
        model.addAttribute("order", order);                 // Here order object is stored using key "order"
        model.addAttribute("anySettings", true);            // You can store in the model any data
        // TODO: see what methods are in Model class
        return "orderView";
    }

    @RequestMapping("/viewWebRequest")
    public String viewOrderWithWebRequest(
        WebRequest webRequest,                              // Here you can find a lot of data from request
        Model model
    ) {
        String id = webRequest.getParameter("orderId");     // you can get request parameters
        // TODO: see what methods are in WebRequest class
        Order order = repo.get(id);
        model.addAttribute("order", order);
        return "orderView";
    }

    @RequestMapping("/viewWithRequestHeader")
    public String viewOrderWithRequestHeader(
        @RequestParam String id,
        @RequestHeader("User-Agent") String userAgent,       // Here you can get client browser info
        Model model
    ) {
        System.out.println("User-Agent is: " + userAgent);
        // TODO: try to print other header

        Order order = repo.get(id);
        model.addAttribute("order", order);
        return "orderView";
    }

    @RequestMapping("/viewWithSessionAndLocale")
    public String viewOrderWithRequestHeader(
        @RequestParam String id,
        HttpSession httpSession,                              // HttpSession object
        Locale locale,                                        // Locale object
        Model model
    ) {
        // TODO: see what these objects are
        // TODO: try to print sessionID and current locale

        Order order = repo.get(id);
        model.addAttribute("order", order);
        return "orderView";
    }

    @PostMapping("/fileupload")
    public void viewOrderWithRequestHeader(
        @RequestParam("file") MultipartFile file              // Special MultipartObject
    ) {
        // TODO: see what MultipartFile class contains
    }
}
