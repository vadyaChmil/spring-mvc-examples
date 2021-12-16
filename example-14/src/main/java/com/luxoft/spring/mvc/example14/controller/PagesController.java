package com.luxoft.spring.mvc.example14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

    // TODO: see 'index.html' and open this URL in browser

    @RequestMapping("/index")
    public String viewOrder(Model model) {
        model.addAttribute("username", "Mike");
        return "index";
    }

    // TODO: open this URL in your browser

    @RequestMapping("/user")
    public String viewUser(Model model) {
        User user = new User("Mike", 22);
        // TODO: add comment field
        model.addAttribute("user", user);
        return "user";
    }
}
